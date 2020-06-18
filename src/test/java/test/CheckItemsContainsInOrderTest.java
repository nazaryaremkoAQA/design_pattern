package test;

import actions.HomePageActions;
import dataprovider.HomePageDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.BaseTest;

import java.util.List;

public class CheckItemsContainsInOrderTest extends BaseTest {

     @Test(dataProvider = "getProducts", dataProviderClass = HomePageDP.class, description = "check products", groups = "regression")
    public void checkItemsContainsInOrderTest(List<String> expectedProductsName, List<String> expectedProductsPrice) throws InterruptedException {
        HomePageActions actions = new HomePageActions(driver, log);

        actions.openPage();

        log.info("Main page is opened");

        List<String> allProductsName = actions.getAllProductsName();
        List<String> allProductsPrice = actions.getAllProductsPrice();

        Assert.assertEquals(allProductsName, expectedProductsName);
        Assert.assertEquals(allProductsPrice, expectedProductsPrice);
    }
}
