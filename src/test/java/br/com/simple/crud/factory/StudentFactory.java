package br.com.simple.crud.factory;

import br.com.simple.crud.domain.entity.Student;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class StudentFactory {

    public static final Long ID = 1L;
    public static final String NAME = "Ragnar";
    public static final String NEW_NAME = "Odin";
    public static final String LAST_NAME = "L";
    public static final String NEW_LAST_NAME = "G";
    public static final Integer AGE = 18;
    public static final Integer NEW_AGE = 19;

    public Student createStudent() {
        return new Student(ID, NAME, LAST_NAME, AGE);
    }

    public Student createStudent(final String name, final String lastName, final Integer age) {
        return new Student(ID, name, lastName, age);
    }

    public Student createUpdatedStudent() {
        return new Student(ID, NEW_NAME, NEW_LAST_NAME, NEW_AGE);
    }

    public Student createStudentWithoutId() {
        return new Student(NAME, LAST_NAME, AGE);
    }

    public Page<Student> createStudentsPage() {
        final List<Student> students = new ArrayList<>();

        students.add(new Student(ID, NAME, LAST_NAME, AGE));
        students.add(new Student(ID + 1, NAME, LAST_NAME, AGE));
        students.add(new Student(ID + 2, NAME, LAST_NAME, AGE));

        return new PageImpl<>(students);
    }
}
