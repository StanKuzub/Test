package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @Test
    public void validLogin(){
        File fileFF = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://qa-complex-app-for-testing.herokuapp.com/");
        System.out.println("Site was opened");

        webDriver.findElement(By.xpath(".//input[@placeholder='Username']")).clear();
        webDriver.findElement(By.xpath(".//input[@placeholder='Username']")).sendKeys("auto");
        System.out.println("'auto' was inputted");

        webDriver.findElement(By.xpath(".//input[@placeholder='Password']")).clear();
        webDriver.findElement(By.xpath(".//input[@placeholder='Password']")).sendKeys("123456qwerty");
        System.out.println("pass was inputted");

        webDriver.findElement(By.xpath(".//button[text()='Sign In']")).click();
        System.out.println("'Sign In' was clicked");

        Assert.assertTrue("Button Sing Out is not displayed", isButtonSingOutVisible());

        webDriver.quit();
    }

    @Test
    public void invalidLogin(){
        File fileFF = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://qa-complex-app-for-testing.herokuapp.com/");
        System.out.println("Site was opened");

        webDriver.findElement(By.xpath(".//input[@placeholder='Username']")).clear();
        webDriver.findElement(By.xpath(".//input[@placeholder='Username']")).sendKeys("a");
        System.out.println("'auto' was inputted");

        webDriver.findElement(By.xpath(".//input[@placeholder='Password']")).clear();
        webDriver.findElement(By.xpath(".//input[@placeholder='Password']")).sendKeys("123");
        System.out.println("pass was inputted");

        webDriver.findElement(By.xpath(".//button[text()='Sign In']")).click();
        System.out.println("'Sign In' was clicked");

        Assert.assertFalse("Button Sing Out is displayed", isButtonSingOutVisible());

        webDriver.quit();
    }

    private boolean isButtonSingOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[text()='Sign Out']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
