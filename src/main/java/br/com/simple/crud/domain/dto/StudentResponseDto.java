package br.com.simple.crud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto implements Serializable {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
}
