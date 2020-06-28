package pattern.test.decorator;

import pattern.decorator.PaymentScreenPage;

import java.util.Map;
import java.util.function.BiConsumer;

public class PaymentDecorator {

    static final BiConsumer<PaymentScreenPage, Map<String, String>> applyFreePromocode = (dp, map) -> dp.applyPromocode(map.get("freePromo"));
    static final BiConsumer<PaymentScreenPage, Map<String, String>> applyPartialPromocode = (dp, map) -> dp.applyPromocode(map.get("partialPromo"));
    static final BiConsumer<PaymentScreenPage, Map<String, String>> setCreditCard = (dp, map) -> dp.enterCC(map.get("cc"), map.get("year"), map.get("cvv"));
    static final BiConsumer<PaymentScreenPage, Map<String, String>> setInvalidCreditCard = (dp, map) -> dp.enterCC(map.get("invalidCC"), map.get("year"), map.get("cvv"));

    public static BiConsumer<PaymentScreenPage, Map<String, String>> successFlowWithPartialPromo = applyPartialPromocode.andThen(setCreditCard);
    public static BiConsumer<PaymentScreenPage, Map<String, String>> invalidFlowWithInvalidCC = applyPartialPromocode.andThen(setInvalidCreditCard);
 }

