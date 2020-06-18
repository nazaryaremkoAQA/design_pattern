package pattern.strategy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pattern.strategy.pages.actions.IPay;
import pattern.strategy.pages.main_page_blocks.*;

import java.util.Map;

public class PaymentScreenPage {

    private WebDriver driver;
    private CreditCardBlock creditCardBlock;
    private NetBankingBlock netBankingBlock;
    private UserInformationBlock userInformationBlock;
    private PayPalBlock payPalBlock;
    private OrderBlock orderBlock;
    protected IPay iPay;

    public PaymentScreenPage(final WebDriver driver){
        this.driver = driver;
        this.creditCardBlock = PageFactory.initElements(driver, CreditCardBlock.class);
        this.netBankingBlock = PageFactory.initElements(driver, NetBankingBlock.class);
        this.userInformationBlock = PageFactory.initElements(driver, UserInformationBlock.class);
        this.payPalBlock = PageFactory.initElements(driver, PayPalBlock.class);
        this.orderBlock = PageFactory.initElements(driver, OrderBlock.class);
    }

    public void setPay(IPay iPay) {
        this.iPay = iPay;
    }

    public void executePay(Map<String, String> payInfo) {
        iPay.pay(payInfo);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public CreditCardBlock getCreditCardBlock() {
        return creditCardBlock;
    }

    public NetBankingBlock getNetBankingBlock() {
        return netBankingBlock;
    }

    public UserInformationBlock getUserInformationBlock() {
        return userInformationBlock;
    }

    public PayPalBlock getPayPalBlock() {
        return payPalBlock;
    }

    public OrderBlock getOrderBlock() {
        return orderBlock;
    }
}
