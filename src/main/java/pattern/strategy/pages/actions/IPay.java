package pattern.strategy.pages.actions;

import java.util.Map;

public interface IPay {

    void pay(Map<String, String> paymentDetails);

}
