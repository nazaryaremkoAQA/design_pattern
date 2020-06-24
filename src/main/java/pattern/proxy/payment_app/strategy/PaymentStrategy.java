package pattern.strategy.payment_app.strategy;

import org.openqa.selenium.WebDriver;
import pattern.strategy.payment_app.actions.IPay;
import pattern.strategy.payment_app.actions.PayByCreditCard;
import pattern.strategy.payment_app.actions.PayByNetBanking;
import pattern.strategy.payment_app.actions.PayByPayPal;

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