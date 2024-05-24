import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginAssignmentTest {

    private static WebDriver driver;
    private static final String baseUrl = "https://practicetestautomation.com/practice-test-login/";

    @BeforeAll
    public static void setUpBeforeClass() {
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }

    @Test
    public void testLogin() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        //verifikasi dan validasi url
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, expectedUrl);

        //verifikasi dan validasi text "Congratulations"
        WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'Congratulations')]"));
        Assertions.assertTrue(text.isDisplayed());

        //verifikasi dan validasi button logout
        WebElement logoutButton = driver.findElement(By.xpath("//*[contains(text(), 'Log out')]"));
        Assertions.assertTrue(logoutButton.isDisplayed());
    }

    @Test
        public void negativeUsernameTest() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrectUser");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        //verifikasi dan validasi error message
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assertions.assertTrue(errorMessage.isDisplayed());

        //verifikasi dan validasi text
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("Your username is invalid!"));
    }

    @Test
    public void negativePasswordTest() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("incorrectPassword");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        //verifikasi dan validasi error message
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assertions.assertTrue(errorMessage.isDisplayed());

        //verifikasi dan validasi text
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("Your password is invalid!"));

    }
}
