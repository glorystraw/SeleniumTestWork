package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class SearchPageResultsTest extends MainMethods {

    @Test
    public void CheckSearchPageResults() {
        openHomePage()
                .inputMathSearchForm()
                .goToSearchPage()
                .checkSearchResultsNumber()
                .CheckSearchResultsTitles()
                .CheckSearchResultsAddToCartButtons();

    }
}
