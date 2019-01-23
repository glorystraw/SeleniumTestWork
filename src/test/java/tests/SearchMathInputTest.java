package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class SearchMathInputTest extends MainMethods {

    @Test
    public void CheckSearchInputWithWordMath() {
        openHomePage()
                .checkInputMathSearchForm();
    }
}
