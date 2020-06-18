package test;

import actions.GoogelPageActions;
import actions.GoogleResultActions;
import actions.GoogleVideoActions;
import actions.HomePageActions;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class GoogleTest extends BaseTest {

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
