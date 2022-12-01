package br.com.simple.crud.factory;

import br.com.simple.crud.domain.dto.StudentRequestDto;
import org.apache.commons.lang.StringUtils;

import static br.com.simple.crud.factory.StudentFactory.AGE;
import static br.com.simple.crud.factory.StudentFactory.LAST_NAME;
import static br.com.simple.crud.factory.StudentFactory.NAME;

public class StudentRequestDtoFactory {
    public StudentRequestDto createStudent() {
        return new StudentRequestDto(NAME, LAST_NAME, AGE);
    }

    public StudentRequestDto createStudentWithEmptyNameLastName() {
        return new StudentRequestDto(StringUtils.EMPTY, StringUtils.EMPTY, AGE);
    }

}
