package br.com.simple.crud.resource;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentResourceTest {

    public static final String HELLO_WORLD = "Hello, World!";

    final StudentResource resource;

    StudentResourceTest() {
        resource = new StudentResource();
    }

    @Test
    void getHelloWorldWithSuccess() {
        final String response = resource.helloWorld();
        assertEquals(HELLO_WORLD, response);
    }

}