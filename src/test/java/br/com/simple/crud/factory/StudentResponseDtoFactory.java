package br.com.simple.crud.factory;

import br.com.simple.crud.domain.dto.StudentResponseDto;

import static br.com.simple.crud.factory.StudentFactory.AGE;
import static br.com.simple.crud.factory.StudentFactory.ID;
import static br.com.simple.crud.factory.StudentFactory.LAST_NAME;
import static br.com.simple.crud.factory.StudentFactory.NAME;

public class StudentResponseDtoFactory {
    public StudentResponseDto createStudent() {
        return new StudentResponseDto(ID, NAME, LAST_NAME, AGE);
    }
}
