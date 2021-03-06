package pattern.proxy.payment_app.actions;

import org.openqa.selenium.WebDriver;
import pattern.proxy.payment_app.main_page_blocks.PayPalBlock;

import java.util.Map;

public class PayByPayPal implements IPay {

    PayPalBlock block;

    public PayByPayPal(WebDriver driver) {
        this.block = new PayPalBlock(driver);
    }

    @Override
    public void pay(Map<String, String> paymentDetails) {
        block.fillOutPayPalInfo(paymentDetails.get("userName"), paymentDetails.get("password"));
    }
}
