package br.com.simple.crud.service.builder;

import br.com.simple.crud.domain.dto.StudentRequestDto;
import br.com.simple.crud.domain.dto.StudentResponseDto;
import br.com.simple.crud.domain.entity.Student;
import br.com.simple.crud.factory.StudentFactory;
import br.com.simple.crud.factory.StudentRequestDtoFactory;
import br.com.simple.crud.factory.StudentResponseDtoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class StudentBuilderTest {

    final StudentFactory studentFactory;
    final StudentRequestDtoFactory studentRequestDtoFactory;
    final StudentResponseDtoFactory studentResponseDtoFactory;

    final StudentBuilder studentBuilder;

    StudentBuilderTest() {
        studentBuilder = new StudentBuilder();
        studentFactory = new StudentFactory();
        studentRequestDtoFactory = new StudentRequestDtoFactory();
        studentResponseDtoFactory = new StudentResponseDtoFactory();
    }

    @Test
    void toStudent() {
        final Student expectedStudent = studentFactory.createStudent();
        final StudentRequestDto studentRequestDto = studentRequestDtoFactory.createStudent();

        final Student student = studentBuilder.toStudent(studentRequestDto);

        assertAll(() -> assertNull(student.getId()),
                () -> assertEquals(expectedStudent.getName(), student.getName()),
                () -> assertEquals(expectedStudent.getLastName(), student.getLastName()),
                () -> assertEquals(expectedStudent.getAge(), student.getAge())
        );
    }

    @Test
    void toStudentResponseDto() {
        final Student student = studentFactory.createStudent();
        final StudentResponseDto expectedStudentResponseDto = studentResponseDtoFactory.createStudent();

        final StudentResponseDto studentResponseDto = studentBuilder.toStudentResponseDto(student);

        assertAll(() -> assertNotNull(studentResponseDto),
                () -> assertEquals(expectedStudentResponseDto.getId(), studentResponseDto.getId()),
                () -> assertEquals(expectedStudentResponseDto.getName(), studentResponseDto.getName()),
                () -> assertEquals(expectedStudentResponseDto.getLastName(), studentResponseDto.getLastName()),
                () -> assertEquals(expectedStudentResponseDto.getAge(), studentResponseDto.getAge())
        );

    }
}