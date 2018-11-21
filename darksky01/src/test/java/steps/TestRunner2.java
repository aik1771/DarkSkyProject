package steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)  
@CucumberOptions(
		// This creates cucumber reports
        plugin = {"pretty", "html:target/site/cucumber-pretty"},
        //This create auto method name in camelCase
        snippets = cucumber.api.SnippetType.CAMELCASE,
        
        //Path to your feature file
        features = {"src/test/resources/features"},
        		 tags = {"@today-temperature"},
        // Specify tags to be executed
        //Specify step definition package name (Note: make sure to have this package on current directory) 
        glue = {"steps"}
)
  public class  TestRunner2 {
	
}