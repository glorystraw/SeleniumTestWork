package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By topMenuWhoWeServeLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='WHO WE SERVE']");
    private final By topMenuSubjectsLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='SUBJECTS']");
    private final By topMenuAboutLink = By.xpath("//li[@class='dropdown-submenu']/a[text()='ABOUT']");

    public HomePage checkTopMenuLinksAreDisplayed() {
        Assert.assertTrue(driver.findElement(topMenuWhoWeServeLink).isDisplayed());
        Assert.assertTrue(driver.findElement(topMenuSubjectsLink).isDisplayed());
        Assert.assertTrue(driver.findElement(topMenuAboutLink).isDisplayed());
        return this;
    }

}
