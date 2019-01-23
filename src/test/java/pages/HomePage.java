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

    private final List<String> topMenuLinksList = Arrays.asList("WHO WE SERVE", "SUBJECTS", "ABOUT");
    private final List<String> topMenuWhoWeServeLinksList = Arrays.asList("Students", "Instructors", "Book Authors",
            "Professionals", "Researchers", "Institutions", "Librarians", "Corporations",
            "Societies", "Journal Editors", "Journalists", "Government");
    private final By topMenuLinks = By.xpath("//ul[@class='navigation-menu-items initialized']//a[@class='collapsed']");
    private final By topMenuWhoWeServeLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='WHO WE SERVE']");
    private final By topMenuSubjectsLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='SUBJECTS']");
    private final By whoWeServeSubMenuLinks = By.xpath("//div[@id='Level1NavNode1']//a");
    private final By topMenuWhoWeServeStudentsLink = By.xpath("//div[@id='Level1NavNode1']//a[text()='Students']");
    private final By searchButton = By.xpath("//span[@class='input-group-btn']/button");
    private final By logo = By.xpath("//div[@class='yCmsContentSlot logo']//a");

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

        List<WebElement> menuItemswhoWeServe = driver.findElements(whoWeServeSubMenuLinks);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < menuItemswhoWeServe.size(); i++) {
            String elementTitle = menuItemswhoWeServe.get(i).getText();
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

    public HomePage checkHomePageOpened() {
        clickLogo();
        String newHomePage = driver.getTitle();
        Assert.assertEquals(newHomePage, "Homepage | Wiley");
        return this;
    }

    public HomePage checkSearchButtonEmptyClick() {
        String oldPageData = driver.getPageSource();
        driver.findElement(searchButton).click();
        String newPageData = driver.getPageSource();
        Assert.assertEquals(oldPageData, newPageData);
        return this;
    }

    public HomePage clickLogo() {
        driver.findElement(logo).click();
        return new HomePage(driver);
    }

    public HomePage inputMathSearchForm() {
        driver.findElement(By.xpath("//input[@id='js-site-search-input']")).sendKeys("Math");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
        return this;
    }

    public HomePage checkInputMathSearchForm() {
        Assert.assertTrue(driver.findElement(By.id("ui-id-2")).isDisplayed());
        //  driver.findElements(By.xpath("//aside[@id='ui-id-2']//h3[text()='Suggestions']//following-sibling::div//div[starts-with(., 'math')]")).size();
        Assert.assertEquals(driver.findElements(By.xpath("//aside[@id='ui-id-2']//h3[text()='Suggestions']//following-sibling::div//div[starts-with(., 'math')]")).size(), 4);

        //Two methods to check "math" contains
        driver.findElements(By.xpath("//aside[@id='ui-id-2']//h3[text()='Products']//following-sibling::div//div")).size();
        driver.findElements(By.xpath("//aside[@id='ui-id-2']//h3[text()='Products']//following-sibling::div//div[contains(., 'Math')]")).size();

        List<WebElement> elementList = driver.findElements(By.xpath("//aside[@id='ui-id-2']//h3[text()='Products']//following-sibling::div//div"));
        Assert.assertTrue(elementList.size() == 4, "Unexpected elements count. Expected: " + 4
                + " But we have: " + elementList.size());
        for (WebElement element : elementList) {
            String elementTitle = element.findElement(By.cssSelector(".product-title a")).getText();
            Assert.assertTrue(elementTitle.contains("math"), "Text doesn't contains Math");
        }
        return this;
    }

    public SearchPage goToSearchPage() {
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }
}
