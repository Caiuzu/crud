package br.com.simple.crud.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberContextConfiguration()
@CucumberOptions(features = "src/test/resources/features", glue = "br.com.simple.crud.cucumber.step")
public class CucumberTest {
}
