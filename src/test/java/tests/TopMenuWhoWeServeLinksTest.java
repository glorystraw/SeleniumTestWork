package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class TopMenuWhoWeServeLinksTest extends MainMethods {

    @Test
    public void topMenuWhoWeServeLinks() {
        openHomePage()
                .checkTopMenuWhoWeServeSubLinksNumber()
                .checkTopMenuWhoWeServeTitles();
    }
}
