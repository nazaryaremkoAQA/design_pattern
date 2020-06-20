package test;

import google.actions.GoogelPageActions;
import google.actions.GoogleResultActions;
import google.actions.GoogleVideoActions;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class GoogleMyImplementationTest extends BaseTest {

    private String search = "Selenium Automation";

    @Test(description = "google test", groups = "regression")
    public void googleTest() throws InterruptedException {
        GoogelPageActions googelPageActions = new GoogelPageActions(driver, log);

        googelPageActions.openPage();
        googelPageActions.typeText(search);

        googelPageActions.clickOnNSuggestion(3);

        GoogleResultActions googleResultActions = new GoogleResultActions(driver, log);

        googleResultActions.typeText(search);

        googleResultActions.clickOnNSuggestion(3);
        googleResultActions.clickOnVideo();

        GoogleVideoActions googleVideoActions = new GoogleVideoActions(driver, log);

        System.out.println(googleVideoActions.getResult());


    }
}
