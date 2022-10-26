package br.com.simple.crud.factory;

import br.com.simple.crud.domain.dto.StudentRequestDto;

import static br.com.simple.crud.factory.StudentFactory.AGE;
import static br.com.simple.crud.factory.StudentFactory.LAST_NAME;
import static br.com.simple.crud.factory.StudentFactory.NAME;

public class StudentRequestDtoFactory {
    public StudentRequestDto createStudent() {
        return new StudentRequestDto(NAME, LAST_NAME, AGE);
    }

}
