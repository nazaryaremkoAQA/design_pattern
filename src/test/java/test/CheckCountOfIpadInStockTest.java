package test;

import actions.DetailsPageActions;
import actions.HomePageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class CheckCountOfIpadInStockTest extends BaseTest {

    @Test(description = "check count of ipad in stock", groups = "regression")
    public void checkCountOfIpadInStockTest() {
        HomePageActions homePageActions = new HomePageActions(driver, log);

        homePageActions.openPage();

        log.info("Main page is opened");

        DetailsPageActions detailsPageActions = new DetailsPageActions(driver, log);

        homePageActions.clickOnIpad();

        log.info("Detail page is opened");

        Assert.assertEquals(detailsPageActions.getInStockItem(), 2);

        detailsPageActions.clickOnAddToCart();

        Assert.assertEquals(detailsPageActions.getInStockItem(), 1);
        Assert.assertEquals(detailsPageActions.getCartItem(), 1);


    }
}
