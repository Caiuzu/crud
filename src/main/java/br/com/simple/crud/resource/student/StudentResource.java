package br.com.simple.crud.resource.student;

import br.com.simple.crud.domain.entity.Student;
import br.com.simple.crud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/student")
public class StudentResource {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") final Long id) {
        try {
            return ResponseEntity.ok(studentService.getById(id));
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Student>> getAll(
            @RequestParam(required = false, defaultValue = "true") final Boolean activePagination,
            final Pageable pageable) {
        return ResponseEntity.ok(studentService.findAll(pageable, activePagination));
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") final Long id) {
        studentService.delete(id);
        ResponseEntity.ok(!studentService.existsById(id));
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.update(student));
    }

}
