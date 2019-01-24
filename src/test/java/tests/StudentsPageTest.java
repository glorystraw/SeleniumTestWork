package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class StudentsPageTest extends MainMethods {

    @Test
    public void checkStudentsUrl() {
        openHomePage()
                .clickStudentsMenuItem()
                .checkStudentUrlIsOpened();
    }

    @Test
    public void checkStudentsPageHeader() {
        openHomePage()
                .clickStudentsMenuItem()
                .checkStudentsHeader();
    }

    @Test
    public void checkStudentsPageWileyPlusLink() {
        openHomePage()
                .clickStudentsMenuItem()
                .checkWileyPlusLink();
    }
}
