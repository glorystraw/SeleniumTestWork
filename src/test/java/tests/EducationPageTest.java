package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class EducationPageTest extends MainMethods {

    @Test
    public void CheckEducationPageHeader(){
        openHomePage()
                .goToStudentsPage()
                .goToEducationPage()
                .checkEducationHeader()
                .checkLeftMenuItemsNumber()
                .getLeftMenuLinks();
    }

}
