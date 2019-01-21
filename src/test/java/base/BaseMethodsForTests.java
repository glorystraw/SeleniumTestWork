package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseMethodsForTests {

    private WebDriver driver;
    private final String homePage = "http://www.wiley.com/WileyCDA/";

    private void getDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void openPage(String url) {
        driver.get(url);
    }

    public HomePage openHomePage() {
        getDriver();
        openPage(homePage);
        driver.findElement(By.xpath("//div[@class='modal-dialog']//button[text()='NO']")).click();
        return new HomePage(driver);
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }


}
