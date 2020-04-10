
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.DocFlavor;

public class Logout {
    WebDriver driver;

    @BeforeMethod
    public void beforeMet()
    {
        System.setProperty("webdriver.chrome.driver","D:/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/home");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.className("dropdown-login")).click();
        driver.findElement(By.cssSelector("[href='https://www.phptravels.net/login']")).click();
        driver.findElement(By.cssSelector("input[name = 'username']")).sendKeys("fordhenry@gmail.com");
        driver.findElement(By.cssSelector("input[name = 'password']")).sendKeys("12345678");
        driver.findElement(By.className("loginbtn")).click();
        Thread.sleep(5000);

        String actual = driver.findElement(By.cssSelector(".text-align-left")).getText();
        Assert.assertEquals(actual, "Hi, Henry Ford");
        driver.findElement(By.xpath("//div[contains (@class , 'dropdown-login')]/a[@id = 'dropdownCurrency']")).click();;
        driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
        Thread.sleep(3000);
        String actual1 = driver.findElement(By.xpath("//div[contains (@class , 'dropdown-login')]/a[@id = 'dropdownCurrency']")).getText();
        Assert.assertEquals(actual1, "MY ACCOUNT");
    }

    @AfterMethod
    public void close()
    {
        driver.quit();
    }
}
