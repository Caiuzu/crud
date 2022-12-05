package br.com.simple.crud.service;

import br.com.simple.crud.domain.dto.StudentRequestDto;
import br.com.simple.crud.domain.dto.StudentResponseDto;
import br.com.simple.crud.domain.entity.Student;
import br.com.simple.crud.exception.StudentValidationException;
import br.com.simple.crud.factory.StudentFactory;
import br.com.simple.crud.factory.StudentRequestDtoFactory;
import br.com.simple.crud.factory.StudentResponseDtoFactory;
import br.com.simple.crud.repository.StudentRepository;
import br.com.simple.crud.service.builder.StudentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collections;
import java.util.Set;

import static br.com.simple.crud.factory.StudentFactory.NEW_AGE;
import static br.com.simple.crud.factory.StudentFactory.NEW_LAST_NAME;
import static br.com.simple.crud.factory.StudentFactory.NEW_NAME;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudentServiceTest {
    private StudentService studentService;
    private final StudentFactory studentFactory = new StudentFactory();
    private final StudentRequestDtoFactory studentRequestDtoFactory = new StudentRequestDtoFactory();
    private final StudentResponseDtoFactory studentResponseDtoFactory = new StudentResponseDtoFactory();
    private final StudentRequestDto studentRequestDto = studentRequestDtoFactory.createStudent();
    StudentRepository studentRepositoryMock;
    StudentBuilder studentBuilderMock;
    Validator validatorMock;
    Validator validator;

    private static final Long ONE = 1L;
    private static final Long TWO = 2L;
    private static final Integer PAGE = 1;
    private static final Integer SIZE = 3;
    private static final Boolean ACTIVE_TRUE = true;

    @BeforeEach
    public void init() {
        studentRepositoryMock = mock(StudentRepository.class);
        studentBuilderMock = mock(StudentBuilder.class);
        validatorMock = mock(Validator.class);
        studentService = new StudentService(studentRepositoryMock, studentBuilderMock, validatorMock);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void getStudentByIdWithSuccess() {
        final Student expectedStudent = studentFactory.createStudent();
        final StudentResponseDto studentResponseDto = studentResponseDtoFactory.createStudent();

        when(studentRepositoryMock.getById(anyLong())).thenReturn(expectedStudent);
        when(studentBuilderMock.toStudentResponseDto(any())).thenReturn(studentResponseDto);

        final StudentResponseDto student = studentService.getById(ONE);

        assertEquals(expectedStudent.getId(), student.getId());
        assertEquals(expectedStudent.getAge(), student.getAge());
        assertEquals(expectedStudent.getName(), student.getName());
        assertEquals(expectedStudent.getLastName(), student.getLastName());
    }

    @Test
    void getStudentByIdThrowExceptionStudentNotFound() {
        when(studentRepositoryMock.getById(any())).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, () -> studentService.getById(ONE));
    }

    @Test
    void findAllStudentWithSuccess() {
        final Page<Student> expectedStudentsPage = studentFactory.createStudentsPage();
        final Pageable pageable = PageRequest.of(PAGE, SIZE);

        when(studentRepositoryMock.findAll(pageable)).thenReturn(expectedStudentsPage);
        final Page<Student> studentsPage = studentService.findAll(pageable, ACTIVE_TRUE);

        assertEquals(expectedStudentsPage, studentsPage);
    }

    @Test
    void saveStudentWithSuccess() {
        final Student student = studentFactory.createStudentWithoutId();
        final StudentResponseDto studentResponseDto = studentResponseDtoFactory.createStudent();

        when(studentRepositoryMock.save(any())).thenReturn(student);
        when(studentBuilderMock.toStudentResponseDto(any())).thenReturn(studentResponseDto);
        when(studentBuilderMock.toStudent(any())).thenReturn(student);
        when(validatorMock.validate(any())).thenReturn(Collections.emptySet());

        Set<ConstraintViolation<Student>> violations = this.validator.validate(student);

        final StudentResponseDto savedStudent = studentService.save(studentRequestDto);

        assertNotNull(savedStudent);
        assertTrue(violations.isEmpty());
        assertEquals(ONE, savedStudent.getId());
        assertEquals(student.getName(), savedStudent.getName());
        assertEquals(student.getLastName(), savedStudent.getLastName());
        assertEquals(student.getAge(), savedStudent.getAge());

        verify(studentRepositoryMock, times(1)).save(student);
        verify(studentBuilderMock, times(1)).toStudentResponseDto(student);
        verify(studentBuilderMock, times(1)).toStudent(studentRequestDto);
        verify(validatorMock, times(1)).validate(any());
    }

    @Test
    void saveStudentWithError() {
        final Student student = studentFactory.createStudent();
        final StudentRequestDto studentRequestDto = studentRequestDtoFactory.createStudent();
        when(studentBuilderMock.toStudent(any())).thenReturn(student);

        Set<ConstraintViolation<Student>> violations = this.validator.validate(student);

        assertThrows(StudentValidationException.class, () -> studentService.save(studentRequestDto));
        assertTrue(violations.isEmpty());
        verify(studentBuilderMock, times(1)).toStudent(studentRequestDto);
    }

    @Test
    void saveStudentWithErrorOnValidate() {
        final Student student = studentFactory.createStudentWithEmptyNameAndLastName();
        final StudentRequestDto studentRequestDto = studentRequestDtoFactory.createStudentWithEmptyNameLastName();
        when(studentBuilderMock.toStudent(any())).thenReturn(student);

        Set<ConstraintViolation<Student>> violations = this.validator.validate(student);

        assertThrows(StudentValidationException.class, () -> studentService.save(studentRequestDto));
        assertFalse(violations.isEmpty());
        assertEquals(TWO, violations.size());
        verify(studentBuilderMock, times(1)).toStudent(studentRequestDto);
    }

    @Test
    void deleteStudentWithSuccess() {
        final Student student = studentFactory.createStudent();

        studentService.delete(student.getId());

        assertNotNull(student);
        verify(studentRepositoryMock).deleteById(student.getId());
    }

    @Test
    void deleteStudentWithError() {
        doThrow(IllegalArgumentException.class).when(studentRepositoryMock).deleteById(any());
        assertThrows(IllegalArgumentException.class, () -> studentService.delete(any()));
    }

    @Test
    void updateStudentWithSuccess() {
        final Student student = studentFactory.createStudent(NEW_NAME, NEW_LAST_NAME, NEW_AGE);
        final Student expectedUpdatedStudent = studentFactory.createUpdatedStudent();

        when(studentRepositoryMock.existsById(any())).thenReturn(TRUE);
        when(studentRepositoryMock.save(any())).thenReturn(student);

        final Student updatedStudent = studentService.update(student);

        assertNotNull(updatedStudent);
        assertEquals(expectedUpdatedStudent.getId(), updatedStudent.getId());
        assertEquals(expectedUpdatedStudent.getName(), updatedStudent.getName());
        assertEquals(expectedUpdatedStudent.getLastName(), updatedStudent.getLastName());
        assertEquals(expectedUpdatedStudent.getAge(), updatedStudent.getAge());

        verify(studentRepositoryMock, times(1)).existsById(any());
        verify(studentRepositoryMock, times(1)).save(student);
        verify(studentRepositoryMock).save(student);
    }

    @Test
    void updateStudentWithError() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        studentService = new StudentService(studentRepositoryMock, studentBuilderMock, validator);

        final Student student = studentFactory.createStudentWithoutIdNameAndLastName();

        when(studentRepositoryMock.existsById(any())).thenReturn(Boolean.FALSE);

        assertThrows(StudentValidationException.class, () -> studentService.update(student));
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        assertNotNull(violations);
        assertEquals(TWO, violations.size());
        verify(studentRepositoryMock, times(1)).existsById(anyLong());
    }

    @Test
    void existsByIdWithSuccess() {
        final Student student = studentFactory.createStudent();
        when(studentRepositoryMock.existsById(anyLong())).thenReturn(TRUE);

        final boolean existsById = studentService.existsById(student.getId());

        assertEquals(TRUE, existsById);
        verify(studentRepositoryMock, times(1)).existsById(anyLong());
    }

    @Test
    void existsByIdWithError() {
        doThrow(IllegalArgumentException.class).when(studentRepositoryMock).existsById(anyLong());
        assertThrows(IllegalArgumentException.class, () -> studentService.existsById(anyLong()));
    }
}
