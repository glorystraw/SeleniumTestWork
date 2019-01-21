package tests;

import base.BaseMethodsForTests;
import org.testng.annotations.Test;

public class TopMenuWhoWeServeLinksTest extends BaseMethodsForTests {

    @Test
    public void TopMenuWhoWeServeLinks(){
        openHomePage().checkTopMenuWhoWeAreSubLinksNumber();
    }
    @Test
    public void TopMenuTitlesTest(){
        openHomePage().MakeVisibleTopMenuWhoWeServeLinks().checkTopMenuWhoWeServeTitles();

    }

}
