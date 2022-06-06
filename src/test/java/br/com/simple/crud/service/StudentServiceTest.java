package br.com.simple.crud.service;

import br.com.simple.crud.domain.entity.Student;
import br.com.simple.crud.factory.StudentFactory;
import br.com.simple.crud.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentServiceTest {
    private StudentService studentService;
    private final StudentFactory studentFactory = new StudentFactory();
    StudentRepository studentRepositoryMock;
    private static final Long ONE = 1L;

    @BeforeEach
    public void init() {
        studentRepositoryMock = mock(StudentRepository.class);
        studentService = new StudentService(studentRepositoryMock);
    }

    @Test
    void getStudentWithSuccess() {
        final Student studentExpected = studentFactory.createStudent();
        when(studentRepositoryMock.findById(anyLong())).thenReturn(Optional.of(studentExpected));

        final Student student = studentService.findById(ONE);

        assertEquals(studentExpected.getId(), student.getId());
        assertEquals(studentExpected.getAge(), student.getAge());
        assertEquals(studentExpected.getName(), student.getName());
        assertEquals(studentExpected.getLastName(), student.getLastName());
    }

}