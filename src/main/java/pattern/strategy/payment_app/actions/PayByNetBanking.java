package pattern.strategy.payment_app.actions;

import org.openqa.selenium.WebDriver;
import pattern.strategy.payment_app.main_page_blocks.NetBankingBlock;

import java.util.Map;

public class PayByNetBanking implements IPay {

    NetBankingBlock block;

    public PayByNetBanking(WebDriver driver) {
        this.block = new NetBankingBlock(driver);
    }

    @Override
    public void pay(Map<String, String> paymentDetails) {
        block.fillOutBankingInfo(paymentDetails.get("bank"), paymentDetails.get("year"), paymentDetails.get("pin"));
    }
}
