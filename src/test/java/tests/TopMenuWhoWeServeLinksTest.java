package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class TopMenuWhoWeServeLinksTest extends MainMethods {

    @Test
    public void TopMenuWhoWeServeLinks(){
        openHomePage()
                .checkTopMenuWhoWeServeSubLinksNumber()
                .makeVisibleTopMenuWhoWeServeLinks()
                .checkTopMenuWhoWeServeTitles();
    }
}
