package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StudentsPage {

    private final WebDriver driver;
    private final By studentsPageHeader = By.xpath("//p[@class='sg-title-h1']//span[text()='Students']");
    private final By wileyPlusLinkElement = By.xpath("//a[@href='https://www.wileyplus.com/']");
    private final By topMenuSubjectsLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='SUBJECTS']");
    private final By topMenuSubjectsEducationLink = By.xpath("//div[@id='Level1NavNode2']//a[text()='Education']");
    private final String wileyPlusUrl = "https://www.wileyplus.com/";

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
        //For new site there is no such Element, but we have such link on page
        driver.findElement(wileyPlusLinkElement).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.urlToBe(wileyPlusUrl));
        String currentLink = driver.getCurrentUrl();
        Assert.assertEquals(currentLink, wileyPlusUrl);
        return this;
    }

    public EducationPage goToEducationPage() {
        WebElement link = driver.findElement(topMenuSubjectsLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        driver.findElement(topMenuSubjectsEducationLink).click();
        return new EducationPage(driver);
    }
}
