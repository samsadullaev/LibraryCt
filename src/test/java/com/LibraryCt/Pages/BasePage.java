package com.LibraryCt.Pages;

import com.LibraryCt.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
