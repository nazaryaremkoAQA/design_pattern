package pattern.strategy.pages.dataprovider;

import org.testng.annotations.DataProvider;
import pattern.strategy.pages.strategy.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class PayInfoData {

    @DataProvider
    public Object[][] getPaymentData() {

        Map<String, String> creditCard = new HashMap<>();
        creditCard.put("creditCard", "4149");
        creditCard.put("year", "2019");
        creditCard.put("cvv", "555");

        Map<String, String> banking = new HashMap<>();
        banking.put("bank", "BOFA");
        banking.put("year", "2019");
        banking.put("pin", "4444");

        Map<String, String> payPal = new HashMap<>();
        payPal.put("userName", "nazar");
        payPal.put("password", "1111");

        return new Object[][]{
                {creditCard, PaymentStrategy.CREDIT_CARD},
                {banking, PaymentStrategy.BANKING},
                {payPal, PaymentStrategy.PAYPAL}
        };
    }
}
