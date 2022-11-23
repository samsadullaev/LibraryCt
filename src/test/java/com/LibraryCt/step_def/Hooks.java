package com.LibraryCt.step_def;

import com.LibraryCt.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @After
    public void teardownScenario(Scenario scenario){
        // We will implement taking screenshot in this method
        //   System.out.println("It will be closing browser using cucumber @After each scenario");
        if(scenario.isFailed()){
            byte [] screenshot =    ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }


        Driver.closeDriver();
    }

    //@BeforeStep


    // @BeforeStep
    // public void setupScenarioStepForLogin(){
    //   System.out.println("Setting up browser using cucumber @Before each scenario step for login");
}


