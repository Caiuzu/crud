package br.com.simple.crud.resource.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldResourceTest {
    public static final String HELLO_WORLD = "Hello, World!";
    private final HelloWorldResource resource;

    HelloWorldResourceTest() {
        this.resource = new HelloWorldResource();
    }

    @Test
    void getHelloWorldWithSuccess() {
        final String response = resource.helloWorld();
        assertEquals(HELLO_WORLD, response);
    }
}
