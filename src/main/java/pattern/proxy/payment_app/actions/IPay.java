package pattern.proxy.payment_app.actions;

import java.util.Map;

public interface IPay {

    void pay(Map<String, String> paymentDetails);

}
