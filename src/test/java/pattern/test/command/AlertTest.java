package pattern.test.command;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pattern.command.HomePage;
import test.base.BaseTest;

public class AlertTest extends BaseTest {

    HomePage homePage;

    @BeforeTest
    public void prepare() {
        homePage = new HomePage(driver);
    }

    @Test()
    public void alertValidateTest() {

        homePage.goTo();
        homePage.getElementValidators()
                .stream()
                .parallel()
                .map(el-> el.validate())
                .forEach(result-> Assert.assertTrue(result.booleanValue()));


    }
}