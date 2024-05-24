import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    @Test
    public void testLogin() {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        //verifikasi dan validasi
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, expectedUrl);

        //verifikasi dan validasi text Products
        WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'Products')]"));
        text.isDisplayed();

        driver.quit();

    }
}
