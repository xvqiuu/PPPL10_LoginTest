package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedPage {
    WebDriver driver;

    public LoggedPage(WebDriver driver) {
        this.driver = driver;
    }

    By textCongratulations = By.xpath("//*[contains(test(), 'Congratulations']");
    By logoutButton = By.xpath("//*[contains(text(), 'Log out')]");

    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    public void getTextCongratulations() {
        driver.findElement(textCongratulations).isDisplayed();
    }

    public void getLogoutButton() {
        driver.findElement(logoutButton).isDisplayed();
    }
}
