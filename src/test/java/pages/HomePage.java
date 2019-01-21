package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By topMenuWhoWeServeLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='WHO WE SERVE']");
    private final By topMenuSubjectsLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='SUBJECTS']");
    private final By topMenuAboutLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='ABOUT']");

    private final By WhoWeServeSubMenuLinks = By.xpath("//div[@id='Level1NavNode1']//a");


    private final By topMenuWhoWeServeStudentsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Students']");
    private final By topMenuWhoWeServeInstructorsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Instructors']");
    private final By topMenuWhoWeServeBookAuthorsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Book Authors']");
    private final By topMenuWhoWeServeProfessionalsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Professionals']");
    private final By topMenuWhoWeServeResearchersLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Researchers']");
    private final By topMenuWhoWeServeInstitutionsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Institutions']");
    private final By topMenuWhoWeServeLibrariansLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Librarians']");
    private final By topMenuWhoWeServeCorporationsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Corporations']");
    private final By topMenuWhoWeServeSocietiesLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Societies']");
    private final By topMenuWhoWeServeJournalEditorsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Journal Editors']");
    private final By topMenuWhoWeServeJournalistsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Journalists']");
    private final By topMenuWhoWeServeGovernmentLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Government']");

    public HomePage checkTopMenuLinksAreDisplayed() {
        Assert.assertTrue(driver.findElement(topMenuWhoWeServeLink).isDisplayed());
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeLink).getText(), "WHO WE SERVE");
        Assert.assertTrue(driver.findElement(topMenuSubjectsLink).isDisplayed());
        Assert.assertEquals(driver.findElement(topMenuSubjectsLink).getText(), "SUBJECTS");
        Assert.assertTrue(driver.findElement(topMenuAboutLink).isDisplayed());
        Assert.assertEquals(driver.findElement(topMenuAboutLink).getText(), "ABOUT");
        return this;
    }

    public HomePage checkTopMenuWhoWeAreSubLinksNumber() {
        List<WebElement> submenuItems = driver.findElements(WhoWeServeSubMenuLinks);
        Assert.assertEquals(submenuItems.size(), 12);
        return this;
    }

    public HomePage MakeVisibleTopMenuWhoWeServeLinks() {
        WebElement link = driver.findElement(topMenuWhoWeServeLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        return this;
    }

    public HomePage checkTopMenuWhoWeServeTitles() {

        Assert.assertEquals(driver.findElement(topMenuWhoWeServeStudentsLink).getText(), "Students");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeInstructorsLink).getText(), "Instructors");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeBookAuthorsLink).getText(), "Book Authors");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeProfessionalsLink).getText(), "Professionals");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeResearchersLink).getText(), "Researchers");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeInstitutionsLink).getText(), "Institutions");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeLibrariansLink).getText(), "Librarians");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeCorporationsLink).getText(), "Corporations");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeSocietiesLink).getText(), "Societies");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeJournalEditorsLink).getText(), "Journal Editors");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeJournalistsLink).getText(), "Journalists");
        Assert.assertEquals(driver.findElement(topMenuWhoWeServeGovernmentLink).getText(), "Government");
        return this;

    }

    public StudentsPage goToStudentsPage() {

        MakeVisibleTopMenuWhoWeServeLinks();
        driver.findElement(topMenuWhoWeServeStudentsLink).click();
        return new StudentsPage(driver);

    }


}
