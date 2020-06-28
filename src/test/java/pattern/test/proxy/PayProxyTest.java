package pattern.test.proxy;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pattern.base.BaseTest;
import pattern.proxy.payment_app.dataprovider.PayInfoData;
import pattern.proxy.payment_app.pages.PaymentScreenPage;
import pattern.proxy.payment_app.strategy.PaymentStrategy;

import java.util.Map;

public class PayProxyTest extends BaseTest {

    private PaymentScreenPage paymentScreenPage;

    @BeforeTest
    public void prepare() {
        System.setProperty("env","PROD");
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "getPaymentData", dataProviderClass = PayInfoData.class)
    public void strategyTest(Map<String,String> paymentInfo, PaymentStrategy strategy) {

        paymentScreenPage.goTo();
        paymentScreenPage.getUserInformationBlock().enterUserInfo("Nazar", "Yaremko", "mail@mail.ua");
        paymentScreenPage.setPay(strategy.action(driver));
        paymentScreenPage.executePay(paymentInfo);
        String order = paymentScreenPage.getOrderComponent().placeOrder();
        System.out.println(order);
        Assert.assertTrue(order.length()> 1);
    }
}
