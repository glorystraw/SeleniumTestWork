package tests;

import base.MainMethods;
import org.testng.annotations.Test;
import pages.HomePage;

public class BackToMainPage extends MainMethods {

    HomePage homePage;

    @Test
    public void homePageIsOpened(){

        homePage.checkHomePageTitle();

    }
}
