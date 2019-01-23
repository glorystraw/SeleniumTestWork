package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class StudentsPageTest extends MainMethods {

    @Test
    public void CheckStudentsUrl() {
        openHomePage()
                .goToStudentsPage()
                .checkStudentUrlIsOpened();
    }

    @Test
    public void CheckStudentsPageHeader() {
        openHomePage()
                .goToStudentsPage()
                .checkStudentsHeader();
    }

    @Test
    public void CheckStudentsPageWileyPlusLink() {
        openHomePage()
                .goToStudentsPage()
                .checkWileyPlusLink();
    }

}
