package com.intentwise.api.testframework;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/html-report",
                "json:target/cucumber.json"},
        features = "classpath:features"
)
public class CucumberTestSuite {
}