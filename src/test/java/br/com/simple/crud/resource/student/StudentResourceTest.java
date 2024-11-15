package br.com.simple.crud.resource.student;

import br.com.simple.crud.domain.dto.StudentRequestDto;
import br.com.simple.crud.domain.dto.StudentResponseDto;
import br.com.simple.crud.domain.entity.Student;
import br.com.simple.crud.exception.StudentValidationException;
import br.com.simple.crud.factory.StudentFactory;
import br.com.simple.crud.factory.StudentRequestDtoFactory;
import br.com.simple.crud.factory.StudentResponseDtoFactory;
import br.com.simple.crud.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;

import static br.com.simple.crud.service.StudentServiceTest.ACTIVE_TRUE;
import static br.com.simple.crud.service.StudentServiceTest.PAGE;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudentResourceTest {

    private final StudentService studentServiceMock;
    private final StudentResource studentResource;
    private final StudentFactory studentFactory = new StudentFactory();
    private final StudentResponseDtoFactory studentResponseDtoFactory = new StudentResponseDtoFactory();
    private final StudentRequestDtoFactory studentRequestDtoFactory = new StudentRequestDtoFactory();

    public static final long ID = 1L;
    private static final int ONE = 1;
    private static final Integer SIZE = 3;

    StudentResourceTest() {
        studentServiceMock = mock(StudentService.class);
        studentResource = new StudentResource(studentServiceMock);
    }

    @Test
    void getByIdWithSuccess() {
        StudentResponseDto studentResponseDto = studentResponseDtoFactory.createStudent();
        when(studentServiceMock.getById(anyLong())).thenReturn(studentResponseDto);

        final ResponseEntity<?> studentResourceById = studentResource.getById(ID);

        assertEquals(HttpStatus.OK, studentResourceById.getStatusCode());
        verify(studentServiceMock, times(ONE)).getById(anyLong());
    }

    @Test
    void getAllWithSuccess() {
        final Page<Student> expectedStudentsPage = studentFactory.createStudentsPage();
        final Pageable pageable = PageRequest.of(PAGE, SIZE);

        when(studentServiceMock.findAll(pageable, ACTIVE_TRUE)).thenReturn(expectedStudentsPage);

        final ResponseEntity<?> allStudentsResources = studentResource.getAll(ACTIVE_TRUE, pageable);

        assertEquals(expectedStudentsPage, allStudentsResources.getBody());
        verify(studentServiceMock, times(ONE)).findAll(pageable, ACTIVE_TRUE);
    }

    @Test
    void createWithSuccess() {

        StudentRequestDto studentRequestDto = studentRequestDtoFactory.createStudent();
        StudentResponseDto studentResponseDto = studentResponseDtoFactory.createStudent();

        when(studentServiceMock.save(studentRequestDto)).thenReturn(studentResponseDto);

        ResponseEntity<StudentResponseDto> responseEntity = studentResource.create(studentRequestDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(studentResponseDto, responseEntity.getBody());

    }

    @Test
    void deleteWithSucess() {
        studentResource.delete(ID);

        verify(studentServiceMock, times(ONE)).delete(ID);
        verify(studentServiceMock, times(ONE)).existsById(ID);
    }

    @Test
    void deleteWithError() {
        doThrow(EntityNotFoundException.class).when(studentServiceMock).delete(ID);
        assertThrows(EntityNotFoundException.class, () -> studentResource.delete(ID));
    }

    @Test
    void updateWithSuccess() {
        Student student = studentFactory.createStudent();
        when(studentServiceMock.update(student)).thenReturn(student);

        ResponseEntity<Student> responseEntity = studentResource.update(student);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(student, responseEntity.getBody());
    }

    @Test
    void updateWithError() {
        final Student studentToUpdate = studentFactory.createStudent();
        when(studentServiceMock.update(studentToUpdate)).thenThrow(StudentValidationException.class);

        final ResponseEntity<Student> updatedStudentResource = studentResource.update(studentToUpdate);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, updatedStudentResource.getStatusCode());
        verify(studentServiceMock, times(ONE)).update(studentToUpdate);
    }
}