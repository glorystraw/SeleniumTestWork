package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class StudentsPageTest extends MainMethods {

    @Test
    public void CheckStudentsUrl() {
        openHomePage()
                .clickStudentsMenuItem()
                .checkStudentUrlIsOpened();
    }

    @Test
    public void CheckStudentsPageHeader() {
        openHomePage()
                .clickStudentsMenuItem()
                .checkStudentsHeader();
    }

    @Test
    public void CheckStudentsPageWileyPlusLink() {
        openHomePage()
                .clickStudentsMenuItem()
                .checkWileyPlusLink();
    }
}
