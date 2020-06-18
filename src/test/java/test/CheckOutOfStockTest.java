package test;

import actions.DetailsPageActions;
import actions.HomePageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class CheckOutOfStockTest extends BaseTest {

     @Test(description = "check out of stock", groups = "regression")
    public void checkOutOfStockTest() {

        int count = 0;
        HomePageActions homePageActions = new HomePageActions(driver, log);

        homePageActions.openPage();

        log.info("Main page is opened");

        DetailsPageActions detailsPageActions = new DetailsPageActions(driver, log);

        homePageActions.clickOnIpad();

        log.info("Detail page is opened");

        while (true) {
            detailsPageActions.clickOnAddToCart();
            count++;
            if (detailsPageActions.getAddCartName().equals("Out Of Stock")) {
                break;
            }
        }

        Assert.assertEquals(detailsPageActions.getInStockItem(), 0);
        Assert.assertEquals(detailsPageActions.getCartItem(), count);

    }
}
