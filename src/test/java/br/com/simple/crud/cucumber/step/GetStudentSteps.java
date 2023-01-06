package br.com.simple.crud.cucumber.step;

import br.com.simple.crud.cucumber.adapter.StudentDataTableAdapter;
import br.com.simple.crud.domain.dto.StudentResponseDto;
import br.com.simple.crud.factory.StudentResponseDtoFactory;
import br.com.simple.crud.resource.student.StudentResource;
import br.com.simple.crud.service.StudentService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;

import static br.com.simple.crud.cucumber.step.CreateStudentSteps.FIRST_INDEX;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetStudentSteps {

    private final StudentService studentServiceMock;
    private final StudentResource studentResource;
    private final StudentDataTableAdapter studentDataTableAdapter;
    private final StudentResponseDtoFactory studentResponseDtoFactory = new StudentResponseDtoFactory();

    private Long id;
    private ResponseEntity<?> response;


    public GetStudentSteps(StudentDataTableAdapter studentDataTableAdapter) {
        this.studentDataTableAdapter = studentDataTableAdapter;
        this.studentServiceMock = mock(StudentService.class);
        this.studentResource = new StudentResource(studentServiceMock);
    }

    @Dado("possuo o id {string} de estudante")
    public void iHaveStudentId(String studentId) {
        id = Long.valueOf(studentId);
        StudentResponseDto studentResponseDto = studentResponseDtoFactory.createStudent();
        when(studentServiceMock.getById(id)).thenReturn(studentResponseDto);
    }

    @Quando("envio as informações para consulta do meu estudante")
    public void iSendTheInformationForMyStudentsConsultation() {
        response = studentResource.getById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Então("retornará os seguintes dados")
    public void willReturnTheFollowingData(DataTable dataTable) {
        StudentResponseDto studentResponse = (StudentResponseDto) response.getBody();
        StudentResponseDto studentResponseDtoExpected = studentDataTableAdapter
                .createStudentResponseList(dataTable).get(FIRST_INDEX);

        assertNotNull(studentResponse);
        assertEquals(studentResponseDtoExpected, studentResponse);
        assertAll("studentResponse",
                () -> assertNotNull(studentResponse),
                () -> assertEquals(studentResponseDtoExpected.getId(), studentResponse.getId()),
                () -> assertEquals(studentResponseDtoExpected.getName(), studentResponse.getName()),
                () -> assertEquals(studentResponseDtoExpected.getLastName(), studentResponse.getLastName()),
                () -> assertEquals(studentResponseDtoExpected.getAge(), studentResponse.getAge())
        );
    }

    @Então("retornará erro")
    public void willReturnError() {
        when(studentResource.getById(anyLong())).thenThrow(EntityNotFoundException.class);
        final ResponseEntity<?> studentResourceById = studentResource.getById(anyLong());
        assertEquals(HttpStatus.NOT_FOUND, studentResourceById.getStatusCode());
        verify(studentResource, times(1)).getById(anyLong());
    }
}
