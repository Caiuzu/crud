package br.com.simple.crud.service;

import br.com.simple.crud.domain.entity.Student;
import br.com.simple.crud.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(final Student student) {
        return studentRepository.save(student);
    }

    public Page<Student> findAll(final Integer page, final Integer size, final Boolean active) {
        return studentRepository.findAll(active ? PageRequest.of(page, size) : Pageable.unpaged());
    }

    public Optional<Student> findById(final Long id) {
        return studentRepository.findById(id);
    }

    public void delete(final Long id) {
        studentRepository.deleteById(id);
    }

    public Student update(final Student student) {
        if ((student.getId() != null) && studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        return null;
    }

    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }
}
