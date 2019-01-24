package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EducationPage {

    private final WebDriver driver;
    private final By educationPageHeader = By.xpath("//h1//span[text()='Education']");
    private final By leftMenuLinks = By.xpath("//div[@class='side-panel']//ul/li");
    private final List<String> linkTitles = Arrays.asList("Information & Library Science",
            "Education & Public Policy",
            "K-12 General",
            "Higher Education General",
            "Vocational Technology",
            "Conflict Resolution & Mediation (School settings)",
            "Curriculum Tools- General",
            "Special Educational Needs",
            "Theory of Education",
            "Education Special Topics",
            "Educational Research & Statistics",
            "Literacy & Reading",
            "Classroom Management");

    public EducationPage(WebDriver driver) {
        this.driver = driver;
    }

    public EducationPage checkEducationHeader() {
        Assert.assertTrue(driver.findElement(educationPageHeader).isDisplayed());
        return this;
    }

    public EducationPage checkLeftMenuItemsNumber() {
        List<WebElement> submenuItems = driver.findElements(leftMenuLinks);
        Assert.assertEquals(submenuItems.size(), 13);
        return this;
    }

    public EducationPage checkLeftMenuLinks() {
        List<WebElement> leftMenuItems = driver.findElements(By.xpath("//div[@class='side-panel']//ul//li"));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < leftMenuItems.size(); i++) {
            String elementTitle = leftMenuItems.get(i).getText();
            list.add(elementTitle);
        }
        Assert.assertEquals(list, linkTitles);
        return this;
    }
}
