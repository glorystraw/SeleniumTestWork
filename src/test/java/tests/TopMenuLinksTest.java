package tests;

import base.BaseMethodsForTests;
import org.testng.annotations.Test;

public class TopMenuLinksTest extends BaseMethodsForTests {

    @Test
    public void TopMenuLinksDispay(){
        openHomePage().checkTopMenuLinksAreDisplayed();

    }
}
