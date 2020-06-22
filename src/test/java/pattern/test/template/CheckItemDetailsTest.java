package pattern.test.template;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pattern.template.shopping_app.template_utils.AmazonShopping;
import pattern.template.shopping_app.template_utils.EbayShopping1;
import pattern.template.shopping_app.template_utils.ShoppingTemplate;
import test.base.BaseTest;

public class CheckItemDetailsTest extends BaseTest {

    @Test(dataProvider = "shoppingData")
    public void checkItemPrice(ShoppingTemplate template) {
        template.shop();
    }

    @DataProvider
    public Object[][] shoppingData() {

        String product = "Samsung";
        return new Object[][]{
                new Object[]{
                        new EbayShopping1(driver, product)
                },
                new Object[]{
                        new AmazonShopping(driver, product)
                }
        };

    }

}