package br.com.simple.crud.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
@Builder
@Audited
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Student {
    @Id
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = SEQUENCE, generator = "STUDENT_SEQ")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Nome não informado")
    @Length(max = 10, message = "Nome muito extenso")
    private String name;

    @Column(nullable = false)
    @NotEmpty(message = "Sobrenome não informado")
    @Length(max = 10, message = "Sobrenome muito extenso")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message = "Idade não informada")
    private Integer age;

    public Student(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
