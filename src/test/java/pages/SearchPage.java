package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage {

    private WebDriver driver;
    private final By productItem = By.xpath("//section[@class='product-item ']");
    private final By sectionWithMath = By.xpath("//section[@class='product-item '][contains(., 'Math')]");
    private final By productItemWithCartButton = By.xpath("//section[@class='product-item ']//button[.='Add to cart']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage checkSearchResultsNumber() {
        Assert.assertEquals(driver.findElements(productItem).size(), 10);
        return this;
    }

    public SearchPage CheckSearchResultsTitles() {
        Assert.assertEquals(driver.findElements(sectionWithMath).size(), 10);

//        List<WebElement> elementList = driver.findElements(By.xpath("//aside[@id='ui-id-2']//h3[text()='Products']//following-sibling::div//div"));
//            for ( WebElement element : elementList) {
//                String elementTitle = element.findElement(By.cssSelector(".product-title a")).getText();
//        }
        return this;
    }

    public SearchPage CheckSearchResultsAddToCartButtons() {
        driver.findElements(productItem).size();
        driver.findElements(productItemWithCartButton).size();
        Assert.assertTrue(driver.findElements(productItemWithCartButton).size() > driver.findElements(productItem).size());
        return this;
    }

}
