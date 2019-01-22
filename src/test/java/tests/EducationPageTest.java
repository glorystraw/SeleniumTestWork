package tests;

import base.BaseMethodsForTests;
import org.testng.annotations.Test;

public class EducationPageTest extends BaseMethodsForTests {

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
