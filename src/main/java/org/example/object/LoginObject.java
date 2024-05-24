package org.example.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginObject {
    WebDriver driver;

    public LoginObject(WebDriver driver){
        this.driver = driver;
    }

    public By getInputUsername(){
        return By.id("student");
    }

    public By getInputPassword(){
        return By.id("Password123");
    }

    public By getSubmitButton() {
        return By.id("submit");
    }
}


