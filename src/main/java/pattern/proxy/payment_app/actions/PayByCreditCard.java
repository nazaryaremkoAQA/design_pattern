package pattern.proxy.payment_app.actions;

import org.openqa.selenium.WebDriver;
import pattern.proxy.payment_app.main_page_blocks.CreditCardBlock;

import java.util.Map;

public class PayByCreditCard implements IPay {

    CreditCardBlock block;

    public PayByCreditCard(WebDriver driver) {
        this.block = new CreditCardBlock(driver);
    }

    @Override
    public void pay(Map<String, String> creditDetails) {
        block.fillOutCC(creditDetails.get("creditCard"), creditDetails.get("year"), creditDetails.get("cvv"));
    }
}
