package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class TopMenuLinksTest extends MainMethods {

    @Test
    public void topMenuLinksDisplay() {
        openHomePage()
                .checkTopMenuLinksAreDisplayed()
                .checkTopMenuLinksHaveText();
    }
}
