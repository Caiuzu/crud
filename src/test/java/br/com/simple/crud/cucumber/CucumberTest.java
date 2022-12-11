package br.com.simple.crud.cucumber;

import br.com.simple.crud.CrudApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration()
@CucumberOptions(features = "src/test/resources/features", glue = "br.com.simple.crud.cucumber.step")
@SpringBootTest(classes = {CrudApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberTest {
}
