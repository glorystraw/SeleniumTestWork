package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage checkSearchResultsNumber() {
        driver.findElements(By.xpath("//section[@class='product-item ']")).size();
        Assert.assertEquals(driver.findElements(By.xpath("//section[@class='product-item ']")).size(), 10);
        return this;
    }

    public SearchPage CheckSearchResultsTitles() {
        driver.findElements(By.xpath("//section[@class='product-item '][contains(., 'Math')]")).size();
        Assert.assertEquals(driver.findElements(By.xpath("//section[@class='product-item '][contains(., 'Math')]")).size(), 10);

//        List<WebElement> elementList = driver.findElements(By.xpath("//aside[@id='ui-id-2']//h3[text()='Products']//following-sibling::div//div"));
//            for ( WebElement element : elementList) {
//                String elementTitle = element.findElement(By.cssSelector(".product-title a")).getText();
//        }
        return this;
    }

    public SearchPage CheckSearchResultsAddToCartButtons() {
        driver.findElements(By.xpath("//section[@class='product-item ']")).size();
        driver.findElements(By.xpath("//section[@class='product-item ']//button[.='Add to cart']")).size();
        Assert.assertTrue(driver.findElements(By.xpath("//section[@class='product-item ']//button[.='Add to cart']")).size() > driver.findElements(By.xpath("//section[@class='product-item ']")).size());
        return this;
    }

}
