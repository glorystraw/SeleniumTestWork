package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class TopMenuLinksTest extends MainMethods {

    @Test
    public void TopMenuLinksDisplay() {
        openHomePage()
                .checkTopMenuLinksAreDisplayed()
                .checkTopMenuLinksHaveText();
    }
}
