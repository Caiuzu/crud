package br.com.simple.crud.service;

import br.com.simple.crud.domain.dto.StudentRequestDto;
import br.com.simple.crud.domain.dto.StudentResponseDto;
import br.com.simple.crud.domain.entity.Student;
import br.com.simple.crud.exception.StudentValidationException;
import br.com.simple.crud.repository.StudentRepository;
import br.com.simple.crud.service.builder.StudentBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentBuilder studentBuilder;
    private final Validator validator;

    public StudentResponseDto save(final StudentRequestDto studentRequestDto) {
        final Student student = studentBuilder.toStudent(studentRequestDto);
        final List<String> violations = getConstraintViolations(student);

        if ((student.getId() == null) && violations.isEmpty()) {
            return studentBuilder.toStudentResponseDto(studentRepository.save(student));
        }
        throw new StudentValidationException(violations.toString());
    }

    public Page<Student> findAll(final Pageable pageable, final Boolean active) {
        return studentRepository.findAll(active ? pageable : Pageable.unpaged());
    }

    public StudentResponseDto getById(final Long id) {
        return studentBuilder.toStudentResponseDto(studentRepository.getById(id));
    }

    public void delete(final Long id) {
        studentRepository.deleteById(id);
    }

    public Student update(final Student student) {
        final List<String> violations = getConstraintViolations(student);

        if (studentRepository.existsById(student.getId()) && violations.isEmpty()) {
            return studentRepository.save(student);
        }
        throw new StudentValidationException(violations.toString());
    }

    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

    private List<String> getConstraintViolations(final Student student) {
        final Set<ConstraintViolation<Student>> violations = validator.validate(student);
        return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}
