package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class SearchPageResultsTest extends MainMethods {

    @Test
    public void checkSearchPageResults() {
        openHomePage()
                .inputMathInSearchForm()
                .goToSearchPage()
                .checkSearchResultsNumber()
                .checkSearchResultsTitles()
                .checkSearchResultsAddToCartButtons()
                .checkSearchResultSame();
    }
}
