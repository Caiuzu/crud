package br.com.simple.crud.cucumber.step;

import br.com.simple.crud.cucumber.adapter.StudentDataTableAdapter;
import br.com.simple.crud.domain.dto.StudentRequestDto;
import br.com.simple.crud.domain.dto.StudentResponseDto;
import br.com.simple.crud.exception.StudentValidationException;
import br.com.simple.crud.resource.student.StudentResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateStudentSteps {
    private final StudentResource studentResource;
    private final StudentDataTableAdapter studentDataTableAdapter;
    private StudentRequestDto studentRequestDto;
    private StudentValidationException studentValidationException;
    private ResponseEntity<StudentResponseDto> studentResponseDtoResponseEntity;

    public static final int FIRST_INDEX = 0;

    public CreateStudentSteps(StudentResource studentResource, StudentDataTableAdapter studentDataTableAdapter) {
        this.studentResource = studentResource;
        this.studentDataTableAdapter = studentDataTableAdapter;
    }

    @Dado("que possuo as informações do estudante")
    public void iHaveStudentInformation(final DataTable dataTable) {
        studentRequestDto = studentDataTableAdapter.createStudentList(dataTable).get(FIRST_INDEX);
    }

    @Quando("envio as informações do meu estudante")
    public void sendMyStudentInformation() {
        studentResponseDtoResponseEntity = studentResource.create(studentRequestDto);
    }

    @Então("deverá ser cadastrado com sucesso")
    public void mustBeSuccessfullyRegistered() {
        assertEquals(HttpStatus.CREATED, studentResponseDtoResponseEntity.getStatusCode());
    }

    @Quando("envio as informações do meu estudante com erro")
    public void sendMyStudentInformationWithError() {
        studentValidationException = assertThrows(StudentValidationException.class, () -> studentResource.create(studentRequestDto));
    }

    @Então("não deverá ser cadastrado")
    public void mustNotBeRegistered() {
        assertEquals("[Nome não informado]", studentValidationException.getMessage());
    }

}
