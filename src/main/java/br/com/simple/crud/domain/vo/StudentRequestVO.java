package br.com.simple.crud.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestVO implements Serializable {
    private String name;
    private String lastName;
    private Integer age;
}
