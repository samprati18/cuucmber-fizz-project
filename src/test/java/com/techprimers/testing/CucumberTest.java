package com.techprimers.testing;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.techprimers.testing",
        plugin = {
                "html:target/basicReport", "json:target/basicReport/cucumber.json",
                "pretty:target/basicReport/cucumber-pretty.txt",
                "usage:target/basicReport/cucumber-usage.json", "junit:target/basicReport/cucumber-results.xml",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)
public class CucumberTest {
}
