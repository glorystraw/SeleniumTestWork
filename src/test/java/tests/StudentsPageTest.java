package tests;

import base.BaseMethodsForTests;
import org.testng.annotations.Test;

public class StudentsPageTest extends BaseMethodsForTests {


    @Test
    public void CheckStudentsUrl() {
        openHomePage()
                .goToStudentsPage()
                .checkStudentUrlIsOpened();


    }
    @Test
    public void CheckStudentsPageHeader(){
        openHomePage()
                .goToStudentsPage()
                .checkStudentsHeader();
    }
    @Test
    public void CheckStudentsPageWileyPlusLink(){
        openHomePage()
                .goToStudentsPage()
                .checkWileyPlusLink();
    }

}
