package br.com.simple.crud.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class StudentResource {

    @GetMapping("world")
    public String helloWorld() {
        return "Hello, World!";
    }

}
