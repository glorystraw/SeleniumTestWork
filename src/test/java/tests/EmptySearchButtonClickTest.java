package tests;

import base.MainMethods;
import org.testng.annotations.Test;

public class EmptySearchButtonClickTest extends MainMethods {

    @Test
    public void CheckEmptySearchButtonClick(){
        openHomePage()
                .checkSearchButtonEmptyClick();
    }
}
