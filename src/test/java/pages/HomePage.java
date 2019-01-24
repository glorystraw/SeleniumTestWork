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

    private final WebDriver driver;

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
    private final By searchMathSuggestions = By.xpath("//aside[@id='ui-id-2']//h3[text()='Suggestions']//following-sibling::div//div[starts-with(., 'math')]");
    private final By searchProductsSuggestions = By.xpath("//aside[@id='ui-id-2']//h3[text()='Products']//following-sibling::div//div");
    private final By searchProductsTitleSuggestions = By.xpath("//aside[@id='ui-id-2']//h3[text()='Products']//following-sibling::div//div/a");
    private final By searchInputField = By.xpath("//input[@id='js-site-search-input']");


    public HomePage checkTopMenuLinksAreDisplayed() {
        List<WebElement> topMenuItems = driver.findElements(topMenuLinks);
        for (WebElement link : getMenuLinksElements()) {
            Assert.assertTrue(link.isDisplayed(), "Link in top menu:" + link.getText() + "is not displayed.");
        }
        return this;
    }

    public HomePage checkTopMenuLinksHaveText() {
        Assert.assertEquals(topMenuLinksList.size(), getMenuLinksElements().size(),
                "We have different number of elements in Top menu: ");
        for (int linkIndex = 0; linkIndex < topMenuLinksList.size(); linkIndex++) {
            Assert.assertEquals(topMenuLinksList.get(linkIndex), getMenuLinksElements().get(linkIndex).getText(),
                    "We have different link titles in Top menu:");
        }
        return this;
    }

    public HomePage checkTopMenuWhoWeServeSubLinksNumber() {
        List<WebElement> submenuItems = driver.findElements(whoWeServeSubMenuLinks);
        Assert.assertEquals(submenuItems.size(), 12, "We have different number of links in Who We Serve dropdown menu: ");
        return this;
    }

    public HomePage checkTopMenuWhoWeServeTitles() {
        makeVisibleTopMenuWhoWeServeLinks();
        List<WebElement> menuItemsWhoWeServe = driver.findElements(whoWeServeSubMenuLinks);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < menuItemsWhoWeServe.size(); i++) {
            String elementTitle = menuItemsWhoWeServe.get(i).getText();
            list.add(elementTitle);
        }
        Assert.assertEquals(list, topMenuWhoWeServeLinksList, "We have different link titles in Who We Serve dropdown menu: ");
        return this;
    }

    public StudentsPage clickStudentsMenuItem() {
        makeVisibleTopMenuWhoWeServeLinks();
        driver.findElement(topMenuWhoWeServeStudentsLink).click();
        return new StudentsPage(driver);
    }

    public HomePage checkHomePageIsOpened() {
        clickLogo();
        String newHomePage = driver.getTitle();
        Assert.assertEquals(newHomePage, "Homepage | Wiley");
        return this;
    }

    public HomePage checkNoChangesForEmptySearch() {
        String oldPageData = driver.getPageSource();
        clickSearchButton();
        String newPageData = driver.getPageSource();
        Assert.assertEquals(oldPageData, newPageData, "Page has changes");
        return this;
    }

    public HomePage inputMathInSearchForm() {
        driver.findElement(searchInputField).sendKeys("Math");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            System.out.println("Input is failed");
        }
        return this;
    }

    public HomePage checkInputMathSearchForm() {
        inputMathInSearchForm();
        Assert.assertTrue(driver.findElement(By.id("ui-id-2")).isDisplayed());
        Assert.assertEquals(driver.findElements(searchMathSuggestions).size(), 4,
                "We have different number of suggestions starting with Math: ");
        List<WebElement> elementList = driver.findElements(searchProductsSuggestions);
        //For new site we have five product suggestions in search output
        Assert.assertEquals(elementList.size(), 5,
                "We have different number of search results in products suggestion block:");
        for (WebElement element : elementList) {
            String elementTitle = element.findElement(searchProductsTitleSuggestions).getText();
            Assert.assertTrue(elementTitle.contains("Math"), "Text doesn't contain Math");
        }
        return this;
    }

    public SearchPage goToSearchPage() {
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    private List<WebElement> getMenuLinksElements() {
        return driver.findElements(topMenuLinks);
    }

    private HomePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new HomePage(driver);
    }

    private HomePage clickLogo() {
        driver.findElement(logo).click();
        return new HomePage(driver);
    }

    private HomePage makeVisibleTopMenuWhoWeServeLinks() {
        WebElement link = driver.findElement(topMenuWhoWeServeLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        return this;
    }

}
