package br.com.simple.crud.cucumber.step;

import br.com.simple.crud.resource.world.HelloWorldResource;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Steps {

    private String result;
    private HelloWorldResource helloWorldResource;

    @Dado("que acessou a função de Hello World")
    public void thatAccessedHelloWorldFunction() {
        helloWorldResource = new HelloWorldResource();
        result = helloWorldResource.helloWorld();
    }

    @Então("deverá ser exibido a mensagem de {string} com sucesso")
    public void messageShouldBeDisplayedWithSuccess(final String parameter) {
        assertEquals(result, parameter);
    }
}
