package br.com.simple.crud.factory;

import br.com.simple.crud.domain.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class StudentFactory {

    public static final Long ID = 1L;
    public static final String NAME = "RAGNAR";
    public static final String LAST_NAME = "L";
    public static final Integer AGE = 18;

    public Student createStudent() {
        return new Student(ID, NAME, LAST_NAME, AGE);
    }

    public Student createStudentWithoutId() {
        return new Student(NAME, LAST_NAME, AGE);
    }

    public Page<Student> createStudentsPage() {
        final List<Student> students = new ArrayList<>();

        students.add(new Student(ID, NAME, LAST_NAME, AGE));
        students.add(new Student(ID+1, NAME, LAST_NAME, AGE));
        students.add(new Student(ID+2, NAME, LAST_NAME, AGE));

        return new PageImpl<>(students);
    }
}
