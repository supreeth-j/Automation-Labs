package com.swaglabs.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // Path to your feature files
        glue = "com.swaglabs.stepdefinition"  ,
        plugin = {
                "pretty",                               // Standard pretty format console output
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_script.txt"
        },
        monochrome = true,                          // Display console output in a readable format
        tags ="@test or @reg",                    // Run scenarios tagged as "@smoke" (customize as needed)
        dryRun = false                           //if true then check mapping, if false then execution will start

        // Display console output in a readable format
        // Run scenarios tagged as "@smoke" (customize as needed)

)
public class TestRunner {

}
