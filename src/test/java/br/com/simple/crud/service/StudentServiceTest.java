package br.com.simple.crud.service;

import br.com.simple.crud.domain.entity.Student;
import br.com.simple.crud.factory.StudentFactory;
import br.com.simple.crud.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentServiceTest {
    private StudentService studentService;
    private final StudentFactory studentFactory = new StudentFactory();
    StudentRepository studentRepositoryMock;
    private static final Long ONE = 1L;
    private static final Integer PAGE = 1;
    private static final Integer SIZE = 3;
    private static final Boolean ACTIVE_TRUE = true;

    @BeforeEach
    public void init() {
        studentRepositoryMock = mock(StudentRepository.class);
        studentService = new StudentService(studentRepositoryMock);
    }

    @Test
    void getStudentByIdWithSuccess() {
        final Student studentExpected = studentFactory.createStudent();
        when(studentRepositoryMock.getById(anyLong())).thenReturn(studentExpected);

        final Student student = studentService.getById(ONE);

        assertEquals(studentExpected.getId(), student.getId());
        assertEquals(studentExpected.getAge(), student.getAge());
        assertEquals(studentExpected.getName(), student.getName());
        assertEquals(studentExpected.getLastName(), student.getLastName());
    }

    @Test
    void getStudentByIdThrowExceptionStudentNotFound() {
        when(studentRepositoryMock.getById(any())).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, () -> studentService.getById(ONE));
    }

    @Test
    void findAllStudentWithSucess() {
        final Page<Student> studentsPageExpected = studentFactory.createStudentsPage();
        final Pageable pageable = PageRequest.of(PAGE, SIZE);

        when(studentRepositoryMock.findAll(pageable)).thenReturn(studentsPageExpected);
        final Page<Student> studentsPage = studentService.findAll(PAGE, SIZE, ACTIVE_TRUE);

        assertEquals(studentsPageExpected, studentsPage);
    }

}