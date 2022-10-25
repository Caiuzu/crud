package br.com.simple.crud.service.builder;

import br.com.simple.crud.domain.dto.StudentRequestDto;
import br.com.simple.crud.domain.dto.StudentResponseDto;
import br.com.simple.crud.domain.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentBuilder {

    public Student toStudent(final StudentRequestDto studentRequestDto) {
        return Student.builder()
                .name(studentRequestDto.getName())
                .lastName(studentRequestDto.getLastName())
                .age(studentRequestDto.getAge())
                .build();
    }

    public StudentResponseDto toStudentResponseDto(final Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .build();
    }
}
