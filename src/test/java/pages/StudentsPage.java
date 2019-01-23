package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StudentsPage {

    private WebDriver driver;
    private final By studentsPageHeader = By.xpath("//p[@class='sg-title-h1']//span[text()='Students']");
    private final By wileyPlusLink = By.xpath("//a[@href='https://www.wileyplus.com/']");
    private final By topMenuSubjectsLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='SUBJECTS']");
    private final By topMenuSubjectsEducationLink = By.xpath("//div[@id='Level1NavNode2']//a[text()='Education']");


    public StudentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public StudentsPage checkStudentUrlIsOpened() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.wiley.com/en-ru/students");
        return this;
    }

    public StudentsPage checkStudentsHeader() {
        Assert.assertTrue(driver.findElement(studentsPageHeader).isDisplayed());
        return this;
    }

    public StudentsPage checkWileyPlusLink() {
        //For old site
        // Assert.assertTrue(driver.findElement(By.linkText("WileyPLUS")).isDisplayed());
        //For new site
        driver.findElement(wileyPlusLink).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.urlToBe("https://www.wileyplus.com/"));
        String currentLink = driver.getCurrentUrl();
        Assert.assertEquals(currentLink, "https://www.wileyplus.com/");
        return this;
    }

    public EducationPage goToEducationPage(){
        WebElement link = driver.findElement(topMenuSubjectsLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        driver.findElement(topMenuSubjectsEducationLink).click();
        return new EducationPage(driver);
    }
}
