
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Language {
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
    public void test1()
    {


        driver.findElement(By.xpath("//a[@href = '#hotels']")).click();
        driver.findElement(By.xpath("//div[contains(@style, 'top: 285.5px')]//input")).sendKeys("New York");

        try
        {
            Thread.sleep(100000);
        }
        catch(InterruptedException e) {}



    }

    @AfterMethod
    public void close()
    {
        driver.quit();
    }
}
