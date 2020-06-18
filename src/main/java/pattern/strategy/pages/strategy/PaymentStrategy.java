package pattern.strategy.pages.strategy;

import org.openqa.selenium.WebDriver;
import pattern.strategy.pages.actions.IPay;
import pattern.strategy.pages.actions.PayByCreditCard;
import pattern.strategy.pages.actions.PayByNetBanking;
import pattern.strategy.pages.actions.PayByPayPal;

public enum PaymentStrategy {

    CREDIT_CARD {
        public IPay action(WebDriver driver) {
            return new PayByCreditCard(driver);
        }
    },
    BANKING {
        public IPay action(WebDriver driver) {
            return new PayByNetBanking(driver);
        }
    },
    PAYPAL {
        public IPay action(WebDriver driver) {
            return new PayByPayPal(driver);
        }
    };

    public abstract IPay action(WebDriver driver);

}
