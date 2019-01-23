package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class EducationPageTest extends MainMethods {

    @Test
    public void checkEducationPageHeader(){
        openHomePage()
                .clickStudentsMenuItem()
                .goToEducationPage()
                .checkEducationHeader()
                .checkLeftMenuItemsNumber()
                .getLeftMenuLinks();
    }
}
