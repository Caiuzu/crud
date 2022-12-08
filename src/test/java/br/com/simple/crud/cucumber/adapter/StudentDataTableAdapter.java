package br.com.simple.crud.cucumber.adapter;

import br.com.simple.crud.domain.dto.StudentRequestDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDataTableAdapter {
    private static final String NAME = "name";
    private static final String LAST_NAME = "last_name";
    private static final String AGE = "age";

    @DataTableType()
    public List<StudentRequestDto> createStudentList(final DataTable dataTable) {
        return dataTable
                .asMaps(String.class, String.class)
                .stream()
                .map(column -> {
                    return new StudentRequestDto(column.get(NAME), column.get(LAST_NAME), Integer.parseInt(column.get(AGE)));
                })
                .collect(Collectors.toList());
    }
}
