package br.com.simple.crud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto implements Serializable {
    private String name;
    private String lastName;
    private Integer age;
}
