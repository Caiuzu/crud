package br.com.simple.crud.resource.student;

import br.com.simple.crud.domain.dto.StudentResponseDto;
import br.com.simple.crud.factory.StudentResponseDtoFactory;
import br.com.simple.crud.service.StudentService;
import com.sun.xml.bind.v2.TODO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudentResourceTest {

    private final StudentService studentServiceMock;
    private final StudentResource studentResource;
    private final StudentResponseDtoFactory studentResponseDtoFactory = new StudentResponseDtoFactory();

    StudentResourceTest() {
        studentServiceMock = mock(StudentService.class);
        studentResource = new StudentResource(studentServiceMock);
    }

    @Test
    void getByIdWithSuccess() {
        StudentResponseDto studentResponseDto = studentResponseDtoFactory.createStudent();
        when(studentServiceMock.getById(anyLong())).thenReturn(studentResponseDto);

        final ResponseEntity<?> studentResourceById = studentResource.getById(1L);

        assertEquals(HttpStatus.OK, studentResourceById.getStatusCode());
        verify(studentServiceMock,times(1)).getById(anyLong());
    }

    @Test
    void getAll() {
        TODO.checkSpec("Not yet implemented");
    }

    @Test
    void create() {
        TODO.checkSpec("Not yet implemented");
    }

    @Test
    void delete() {
        TODO.checkSpec("Not yet implemented");
    }

    @Test
    void update() {
        TODO.checkSpec("Not yet implemented");
    }
}