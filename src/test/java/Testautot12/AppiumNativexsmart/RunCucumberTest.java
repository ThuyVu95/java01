package Testautot12.AppiumNativexsmart;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, monochrome = true, features = "src/test/resources/Testautot12/loginapp.feature", glue = "Stepdefination")
public class RunCucumberTest {
}