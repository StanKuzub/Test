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
    public void validTest(){
        File fileFF = new File("./src/drivers/chromedriver9104.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://qa-complex-app-for-testing.herokuapp.com");
        System.out.println("Site was opened");
        webDriver.findElement(By.xpath(".//input[@placeholder='Username']")).clear();
        webDriver.findElement(By.xpath(".//input[@placeholder='Username']")).sendKeys("auto");

        System.out.println("'auto' was inputted");
        webDriver.findElement(By.xpath(".//input[@placeholder='Password']")).clear();
        webDriver.findElement(By.xpath(".//input[@placeholder='Password']")).sendKeys("123456qwerty");
        System.out.println("pass was inputted");

        webDriver.findElement(By.xpath(".//button[text()='Sign In']")).click();
        System.out.println("Button was clicked");

        Assert.assertTrue("Button SignOut is not displayed", isButtonSignOutVisible());
        webDriver.quit();
    }

    @Test
    public void unValidTest(){
        File fileFF = new File("./src/drivers/chromedriver9104.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://qa-complex-app-for-testing.herokuapp.com");
        System.out.println("Site was opened");
        webDriver.findElement(By.xpath(".//input[@placeholder='Username']")).clear();
        webDriver.findElement(By.xpath(".//input[@placeholder='Username']")).sendKeys("aauuutttooo1111");

        System.out.println("'auto' was inputted");
        webDriver.findElement(By.xpath(".//input[@placeholder='Password']")).clear();
        webDriver.findElement(By.xpath(".//input[@placeholder='Password']")).sendKeys("1234566");
        System.out.println("pass was inputted");

        webDriver.findElement(By.xpath(".//button[text()='Sign In']")).click();
        System.out.println("Button was clicked");

        Assert.assertFalse("Button SignOut is displayed", isButtonSignOutVisible());
        webDriver.quit();
    }

    private boolean isButtonSignOutVisible() {
        try{
            return webDriver.findElement(By.xpath(".//button[text()='Sign Out']")).isDisplayed();
        } catch (Exception e){
            return false;
        }

    }
}
