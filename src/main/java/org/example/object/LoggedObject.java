package org.example.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedObject {
    WebDriver driver;

    public LoggedObject(WebDriver driver){
        this.driver = driver;
    }

    public By getTextCongratulations() {
        return By.xpath("*[contains(text(), 'Congratulations']");
    }

    public By getLogoutButton() {
        return By.xpath("//*[contains(text(), 'Log out')]");
    }
}
