
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Contact {
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

        driver.findElement(By.className("arrow-indicator")).click();
        driver.findElement(By.xpath("//nav[contains(@class, 'main-nav-menu')]//a[text()='Contact']")).click();
        Thread.sleep(3000);

    }

    @AfterMethod
    public void close()
    {
        driver.quit();
    }
}
