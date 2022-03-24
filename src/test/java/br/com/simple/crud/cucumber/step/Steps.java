package br.com.simple.crud.cucumber.step;

import br.com.simple.crud.resource.StudentResource;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Então;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Steps {

    private String result;

    @Dado("que acessou a função de Hello World")
    public void thatAccessedHelloWorldFunction() {
        StudentResource studentResource = new StudentResource();
        result = studentResource.helloWorld();
    }

    @Então("deverá ser exibido a mensagem de {string} com sucesso")
    public void messageShouldBeDisplayedWithSuccess(final String parameter) {
        assertEquals(result, parameter);
    }
}
