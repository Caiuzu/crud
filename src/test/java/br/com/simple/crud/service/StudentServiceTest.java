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
import br.com.simple.crud.utils.ConstraintViolationMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static br.com.simple.crud.factory.StudentFactory.NEW_AGE;
import static br.com.simple.crud.factory.StudentFactory.NEW_LAST_NAME;
import static br.com.simple.crud.factory.StudentFactory.NEW_NAME;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    private StudentRepository studentRepositoryMock;
    private StudentBuilder studentBuilderMock;
    private Validator validatorMock;

    private final StudentRequestDto studentRequestDto = studentRequestDtoFactory.createStudent();
    private static final Long ONE = 1L;
    private static final Integer PAGE = 1;
    private static final Integer SIZE = 3;
    private static final Boolean ACTIVE_TRUE = true;
    private static final Boolean ACTIVE_FALSE = false;

    @BeforeEach
    public void init() {
        studentRepositoryMock = mock(StudentRepository.class);
        studentBuilderMock = mock(StudentBuilder.class);
        validatorMock = mock(Validator.class);
        studentService = new StudentService(studentRepositoryMock, studentBuilderMock, validatorMock);
    }

    @Test
    void getStudentByIdWithSuccess() {
        final Student expectedStudent = studentFactory.createStudent();
        final StudentResponseDto studentResponseDto = studentResponseDtoFactory.createStudent();

        when(studentRepositoryMock.getById(anyLong())).thenReturn(expectedStudent);
        when(studentBuilderMock.toStudentResponseDto(any())).thenReturn(studentResponseDto);

        final StudentResponseDto studentResponseDtoResult = studentService.getById(ONE);

        assertNotNull(studentResponseDtoResult);
        assertEquals(expectedStudent.getId(), studentResponseDtoResult.getId());
        assertEquals(expectedStudent.getName(), studentResponseDtoResult.getName());
        assertEquals(expectedStudent.getLastName(), studentResponseDtoResult.getLastName());
        assertEquals(expectedStudent.getAge(), studentResponseDtoResult.getAge());

        verify(studentRepositoryMock, times(1)).getById(ONE);
        verify(studentBuilderMock, times(1)).toStudentResponseDto(expectedStudent);
    }

    @Test
    void getStudentByIdThrowExceptionStudentNotFound() {
        when(studentRepositoryMock.getById(any())).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, () -> studentService.getById(ONE));
        verify(studentRepositoryMock, times(1)).getById(any());
    }

    @Test
    void findAllStudentWithSuccess() {
        final Page<Student> expectedStudentsPage = studentFactory.createStudentsPage();
        final Pageable pageable = PageRequest.of(PAGE, SIZE);

        when(studentRepositoryMock.findAll(pageable)).thenReturn(expectedStudentsPage);
        final Page<Student> studentsPage = studentService.findAll(pageable, ACTIVE_TRUE);

        assertEquals(expectedStudentsPage, studentsPage);
        verify(studentRepositoryMock,times(1)).findAll(pageable);
    }

    @Test
    void findAllStudentWithError() {
        final Pageable pageable = PageRequest.of(PAGE, SIZE);

        final Page<Student> studentsPage = studentService.findAll(pageable, ACTIVE_FALSE);

        assertNull(studentsPage);
    }

    @Test
    void saveStudentWithSuccess() {
        final Student student = studentFactory.createStudentWithoutId();
        final StudentResponseDto studentResponseDto = studentResponseDtoFactory.createStudent();

        when(studentRepositoryMock.save(any())).thenReturn(student);
        when(studentBuilderMock.toStudentResponseDto(any())).thenReturn(studentResponseDto);
        when(studentBuilderMock.toStudent(any())).thenReturn(student);
        when(validatorMock.validate(any())).thenReturn(Collections.emptySet());

        final StudentResponseDto savedStudent = studentService.save(studentRequestDto);

        assertNotNull(savedStudent);
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
    void saveStudentWithErrorNotNullId() {
        final Student student = studentFactory.createStudent();
        when(studentBuilderMock.toStudent(any())).thenReturn(student);
        when(validatorMock.validate(any())).thenReturn(Collections.emptySet());

        assertThrows(StudentValidationException.class, () -> studentService.save(studentRequestDto));

        verify(studentBuilderMock, times(1)).toStudent(studentRequestDto);
        verify(validatorMock, times(1)).validate(any());
        verify(studentRepositoryMock, times(0)).save(student);
        verify(studentBuilderMock, times(0)).toStudentResponseDto(student);
    }

    @Test
    void saveStudentWithErrorOnValidate() {
        final Set<ConstraintViolation<Student>> constraintViolations = new HashSet<>();
        constraintViolations.add(new ConstraintViolationMock());
        final Student student = studentFactory.createStudentWithoutId();
        final StudentRequestDto studentRequestDto = studentRequestDtoFactory.createStudent();

        when(studentBuilderMock.toStudent(any())).thenReturn(student);
        when(validatorMock.validate(any(Student.class))).thenReturn(constraintViolations);

        assertThrows(StudentValidationException.class, () -> studentService.save(studentRequestDto));

        verify(studentBuilderMock, times(1)).toStudent(studentRequestDto);
        verify(validatorMock, times(1)).validate(any());
        verify(studentRepositoryMock, times(0)).save(student);
        verify(studentBuilderMock, times(0)).toStudentResponseDto(student);
    }

    @Test
    void saveStudentWithErrorOnValidateAndWithId() {
        final Set<ConstraintViolation<Student>> constraintViolations = new HashSet<>();
        constraintViolations.add(new ConstraintViolationMock());
        final Student student = studentFactory.createStudent();
        final StudentRequestDto studentRequestDto = studentRequestDtoFactory.createStudent();

        when(studentBuilderMock.toStudent(any())).thenReturn(student);
        when(validatorMock.validate(any(Student.class))).thenReturn(constraintViolations);

        assertThrows(StudentValidationException.class, () -> studentService.save(studentRequestDto));

        verify(studentBuilderMock, times(1)).toStudent(studentRequestDto);
        verify(validatorMock, times(1)).validate(any());
        verify(studentRepositoryMock, times(0)).save(student);
        verify(studentBuilderMock, times(0)).toStudentResponseDto(student);
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
        verify(studentRepositoryMock, times(1)).deleteById(any());
    }

    @Test
    void updateStudentWithSuccess() {
        final Student student = studentFactory.createStudent(NEW_NAME, NEW_LAST_NAME, NEW_AGE);
        final Student expectedUpdatedStudent = studentFactory.createUpdatedStudent();

        when(studentRepositoryMock.existsById(any())).thenReturn(TRUE);
        when(studentRepositoryMock.save(any())).thenReturn(student);
        when(validatorMock.validate(any())).thenReturn(Collections.emptySet());

        final Student updatedStudent = studentService.update(student);

        assertNotNull(updatedStudent);
        assertEquals(expectedUpdatedStudent.getId(), updatedStudent.getId());
        assertEquals(expectedUpdatedStudent.getName(), updatedStudent.getName());
        assertEquals(expectedUpdatedStudent.getLastName(), updatedStudent.getLastName());
        assertEquals(expectedUpdatedStudent.getAge(), updatedStudent.getAge());

        verify(studentRepositoryMock, times(1)).existsById(any());
        verify(studentRepositoryMock, times(1)).save(student);
        verify(validatorMock, times(1)).validate(any());
    }

    @Test
    void updateStudentWithErrorOnExistById() {
        final Student student = studentFactory.createStudent();

        when(validatorMock.validate(any())).thenReturn(Collections.emptySet());
        when(studentRepositoryMock.existsById(any())).thenReturn(Boolean.FALSE);

        assertThrows(StudentValidationException.class, () -> studentService.update(student));
        verify(studentRepositoryMock, times(1)).existsById(anyLong());
        verify(validatorMock, times(1)).validate(any());
    }

    @Test
    void updateStudentWithErrorOnValidation() {
        final Set<ConstraintViolation<Student>> constraintViolations = new HashSet<>();
        constraintViolations.add(new ConstraintViolationMock());
        final Student student = studentFactory.createStudent();

        when(validatorMock.validate(any(Student.class))).thenReturn(constraintViolations);
        when(studentRepositoryMock.existsById(any())).thenReturn(Boolean.TRUE);

        assertThrows(StudentValidationException.class, () -> studentService.update(student));
        verify(studentRepositoryMock, times(1)).existsById(anyLong());
        verify(validatorMock, times(1)).validate(any());
    }

    @Test
    void updateStudentWithErrorOnValidationAndWithoutId() {
        final Set<ConstraintViolation<Student>> constraintViolations = new HashSet<>();
        constraintViolations.add(new ConstraintViolationMock());
        final Student student = studentFactory.createStudent();

        when(validatorMock.validate(any(Student.class))).thenReturn(constraintViolations);
        when(studentRepositoryMock.existsById(any())).thenReturn(Boolean.FALSE);

        assertThrows(StudentValidationException.class, () -> studentService.update(student));
        verify(studentRepositoryMock, times(1)).existsById(anyLong());
        verify(validatorMock, times(1)).validate(any());
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
        verify(studentRepositoryMock, times(1)).existsById(anyLong());
    }
}
