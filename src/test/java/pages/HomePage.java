package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private List<String> topMenuLinksList = Arrays.asList("WHO WE SERVE", "SUBJECTS", "ABOUT");
    private List<String> topMenuWhoWeServeLinksList = Arrays.asList("Students", "Instructors", "Book Authors",
            "Professionals", "Researchers", "Institutions", "Librarians", "Corporations",
            "Societies", "Journal Editors", "Journalists", "Government");
    private final By topMenuLinks = By.xpath("//ul[@class='navigation-menu-items initialized']//a[@class='collapsed']");
    private final By topMenuWhoWeServeLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='WHO WE SERVE']");
    private final By topMenuSubjectsLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='SUBJECTS']");
    private final By whoWeServeSubMenuLinks = By.xpath("//div[@id='Level1NavNode1']//a");
    private final By topMenuWhoWeServeStudentsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Students']");

    public HomePage checkTopMenuLinksAreDisplayed() {
        List<WebElement> topMenuItems = driver.findElements(topMenuLinks);
        for (WebElement link : getMenuLinksElements()) {
            Assert.assertTrue(link.isDisplayed(), "Link:" + link.getText() + "is not displayed.");
        }
        return this;
    }

    public HomePage checkTopMenuLinksHaveText() {
        Assert.assertEquals(topMenuLinksList.size(), getMenuLinksElements().size());
        for (int linkIndex = 0; linkIndex < topMenuLinksList.size(); linkIndex++) {
            Assert.assertEquals(topMenuLinksList.get(linkIndex), getMenuLinksElements().get(linkIndex).getText());
        }
        return this;
    }

    private List<WebElement> getMenuLinksElements() {
        return driver.findElements(topMenuLinks);
    }

    public HomePage makeVisibleTopMenuWhoWeServeLinks() {
        WebElement link = driver.findElement(topMenuWhoWeServeLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        return this;
    }

    public HomePage checkTopMenuWhoWeServeSubLinksNumber() {
        List<WebElement> submenuItems = driver.findElements(whoWeServeSubMenuLinks);
        Assert.assertEquals(submenuItems.size(), 12);
        return this;
    }

    public HomePage checkTopMenuWhoWeServeTitles() {

        List<WebElement> MenuItemswhoWeServe = driver.findElements(whoWeServeSubMenuLinks);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < MenuItemswhoWeServe.size(); i++) {
            String elementTitle = MenuItemswhoWeServe.get(i).getText();
            list.add(elementTitle);
        }
        Assert.assertEquals(list, topMenuWhoWeServeLinksList);
        return this;
    }

    public StudentsPage goToStudentsPage() {
        makeVisibleTopMenuWhoWeServeLinks();
        driver.findElement(topMenuWhoWeServeStudentsLink).click();
        return new StudentsPage(driver);

    }

    public HomePage checkHomePageTitle() {
        clickLogo();
        String newHomePage = driver.getTitle();
        Assert.assertEquals(newHomePage, "Homepage | Wiley");
        return this;
    }

    public HomePage searchButtonClick() {
        driver.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();
        return this;
    }

    public HomePage clickLogo() {
        driver.findElement(By.xpath("//div[@class='yCmsContentSlot logo']//a")).click();
        return new HomePage(driver);
    }

}
