package pattern.test.decorator;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pattern.decorator.PaymentScreenPage;
import test.base.BaseTest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class PaymentDecoratorTest extends BaseTest {


    private PaymentScreenPage page;

    @BeforeTest
    public void prepare() {
        this.page = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentDecoratorTest(BiConsumer<PaymentScreenPage, HashMap> pageConsumer, HashMap<String, String> map,
                                     String status) {
        this.page.goTo();

        System.out.println(pageConsumer.toString());
        pageConsumer.accept(this.page, map);
        this.page.buyProduct();

        Assert.assertEquals(this.page.getStatus(), status, "Status is wrong, something wrong");
     }

    @DataProvider
    public Object[][] getData() {

        Map<String, String> testCaseData = new HashMap<>();
        testCaseData.put("cc", "4111111111111111");
        testCaseData.put("year", "2022");
        testCaseData.put("cvv", "123");
        testCaseData.put("freePromo", "FREEUDEMY");
        testCaseData.put("partialPromo", "PARTIALUDEMY");
        testCaseData.put("invalidCC", "4111111111111122");

        String successStatus = "PASS";
        String failStatus = "FAIL";


        return new Object[][]{
                new Object[]{
                        PaymentDecorator.applyFreePromocode, testCaseData, successStatus
                },
                new Object[]{
                        PaymentDecorator.setCreditCard, testCaseData, successStatus
                },
                new Object[]{

                        PaymentDecorator.successFlowWithPartialPromo, testCaseData, successStatus
                },
                new Object[]{

                        PaymentDecorator.invalidFlowWithInvalidCC, testCaseData ,failStatus
                },
                new Object[]{

                        PaymentDecorator.setInvalidCreditCard, testCaseData ,failStatus
                }


        };
    }
}
