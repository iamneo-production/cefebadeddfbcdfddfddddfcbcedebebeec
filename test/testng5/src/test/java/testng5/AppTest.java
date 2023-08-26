package testng5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AppTest 
{

    WebDriver driver;
    
    @BeforeClass
    public void setup() {
        // Set up the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testLogin() {
        // Navigate to the Snapdeal login page
        driver.get("http://www.snapdeal.com/login");
        
        // Enter the email ID and click continue
        driver.findElement(By.id("userName")).sendKeys("validemail@example.com");
        driver.findElement(By.id("checkUser")).click();
        
        // Enter the password and click login
        driver.findElement(By.id("j_password_login_uc")).sendKeys("validpassword");
        driver.findElement(By.id("submitLoginUC")).click();
        
        // Verify that the user is logged in successfully
        String expectedTitle = "Snapdeal.com | Online Shopping Site India - Shop Electronics, Mobiles, Men & Women Clothing, Shoes - www. Snapdeal.com";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    @AfterClass
    public void end() {
        // Close the browser window
        driver.quit();
    }
}