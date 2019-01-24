package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class BackToMainPageTest extends MainMethods {

    @Test
    public void homePageIsOpened() {
        openHomePage()
                .checkHomePageIsOpened();
    }
}
