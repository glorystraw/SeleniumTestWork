package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class BackToMainPage extends MainMethods {

    @Test
    public void homePageIsOpened() {

        openHomePage().checkHomePageTitle();

    }
}
