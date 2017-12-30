package search;

import cucumber.api.CucumberOptions;
import search.selenium.BaseSelenium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"json:target/cucumber-report.json",
"html:target/cucumber-report"},
strict = true,    
tags = {"@ebay"})

public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void initSelenium(){BaseSelenium.init();}

    @AfterClass
    public static void closeSelenium(){BaseSelenium.close();}

}
