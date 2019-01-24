package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private final WebDriver driver;
    private final By productItem = By.xpath("//section[@class='product-item ']");
    private final By sectionWithMath = By.xpath("//section[@class='product-item '][contains(., 'Math')]");
    private final By productItemWithCartButton = By.xpath("//section[@class='product-item ']//button[.='Add to cart']");
    private final By addToCartButton = By.xpath("//button[.='Add to cart']");
    private final By searchResultProductTitles = By.xpath("//div[@class='products-list']//section[@class='product-item ']//h3//a");
    private final By searchButton = By.xpath("//span[@class='input-group-btn']/button");
    private final By inputField = By.xpath("//input[@id='js-site-search-input']");
    private List<String> productTitles = new ArrayList<>();
    private List<String> newProductTitles = new ArrayList<>();

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage checkSearchResultsNumber() {
        Assert.assertEquals(driver.findElements(productItem).size(), 10,
                "We have different number of search results:");
        return this;
    }

    public SearchPage checkSearchResultsTitles() {
        Assert.assertEquals(driver.findElements(sectionWithMath).size(), driver.findElements(productItem).size(),
                "We have product titles that don't contain word Math");
        return this;
    }

    public SearchPage checkSearchResultsAddToCartButtons() {
        //For new site search results we have search word in Author name too
        //We have to check whole product element content, not only title
        List<WebElement> elementList = driver.findElements(productItem);
        for (WebElement element : elementList) {
            List<WebElement> addToCardButtonList = element.findElements(addToCartButton);
            Assert.assertTrue(addToCardButtonList.size() >= 1, "Product doesn't contain Add to cart button");
        }
        return this;
    }

    public SearchPage saveSearchResultProductsTitles(List<String> productTitles) {
        List<WebElement> elementList = driver.findElements(searchResultProductTitles);
        for (WebElement element : elementList) {
            String productTitle = element.getText();
            productTitles.add(productTitle);
        }
        return this;
    }

    public SearchPage saveNewSearchResultProductsTitles(List<String> newProductTitles) {
        saveSearchResultProductsTitles(productTitles);
        inputMathSearchForm();
        clickSearchButton();
        List<WebElement> elementList = driver.findElements(searchResultProductTitles);
        for (WebElement element : elementList) {
            String productTitle = element.getText();
            newProductTitles.add(productTitle);
        }
        return this;
    }

    public SearchPage checkSearchResultSame() {
        Assert.assertEquals(productTitles, newProductTitles);
        return this;
    }

    private SearchPage inputMathSearchForm() {
        driver.findElement(inputField).sendKeys("Math");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        return this;
    }

    private SearchPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }
}
