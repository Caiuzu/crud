package br.com.simple.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator createValidator() {

        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();

    }
}
