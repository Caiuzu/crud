package br.com.simple.crud.factory;

import br.com.simple.crud.domain.entity.Student;

public class StudentFactory {

    private static final Long ID = 1L;
    private static final String NAME = "RAGNAR";
    private static final String LAST_NAME = "L";
    private static final Integer AGE = 18;

    public Student createStudent() {
        return new Student(ID, NAME, LAST_NAME, AGE);
    }
}
