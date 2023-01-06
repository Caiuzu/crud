package br.com.simple.crud.cucumber.adapter;

import br.com.simple.crud.domain.dto.StudentRequestDto;
import br.com.simple.crud.domain.dto.StudentResponseDto;
import io.cucumber.datatable.DataTable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentDataTableAdapter {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String LAST_NAME = "last_name";
    private static final String AGE = "age";

    public List<StudentRequestDto> createStudentList(final DataTable dataTable) {
        return dataTable
                .asMaps(String.class, String.class)
                .stream()
                .map(column -> {
                    return new StudentRequestDto(column.get(NAME), column.get(LAST_NAME), Integer.parseInt(column.get(AGE)));
                })
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> createStudentResponseList(final DataTable dataTable) {
        return dataTable
                .asMaps(String.class, String.class)
                .stream()
                .map(column -> {
                    return new StudentResponseDto( Long.valueOf(column.get(ID)), column.get(NAME), column.get(LAST_NAME), Integer.parseInt(column.get(AGE)));
                })
                .collect(Collectors.toList());
    }
}
