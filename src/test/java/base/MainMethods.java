package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class MainMethods {

    private WebDriver driver;
    private final String homeUrl = "http://www.wiley.com/WileyCDA/";
    private final By modalWindowButton = By.xpath("//div[@class='modal-dialog']//button[text()='NO']");

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public HomePage openHomePage() {
        driver.get(homeUrl);
        closeModalWindow();
        return new HomePage(driver);
    }

    private MainMethods closeModalWindow() {
        if (driver.findElement(modalWindowButton).isDisplayed()) {
            driver.findElement(modalWindowButton).click();
        }
        return this;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
