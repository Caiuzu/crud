package br.com.simple.crud.utils;

import br.com.simple.crud.domain.entity.Student;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

public class ConstraintViolationMock implements ConstraintViolation<Student> {

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String getMessageTemplate() {
        return null;
    }

    @Override
    public Student getRootBean() {
        return null;
    }

    @Override
    public Class getRootBeanClass() {
        return null;
    }

    @Override
    public Student getLeafBean() {
        return null;
    }

    @Override
    public Student[] getExecutableParameters() {
        return new Student[0];
    }

    @Override
    public Student getExecutableReturnValue() {
        return null;
    }

    @Override
    public Path getPropertyPath() {
        return null;
    }

    @Override
    public Student getInvalidValue() {
        return null;
    }

    @Override
    public ConstraintDescriptor<?> getConstraintDescriptor() {
        return null;
    }

    @Override
    public Student unwrap(Class type) {
        return null;
    }
}
