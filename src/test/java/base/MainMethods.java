package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class MainMethods {

    private WebDriver driver;
    private HomePage homePage;
    private final String homeUrl = "http://www.wiley.com/WileyCDA/";
    private final By modalWindowButton = By.xpath("//div[@class='modal-dialog']//button[text()='NO']");

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    public HomePage openHomePage() {
        driver.get(homeUrl);
        closeModalWindow();
        return new HomePage(driver);
    }

    public HomePage closeModalWindow(){
        driver.findElement(modalWindowButton).click();
        return new HomePage(driver);
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }


}
