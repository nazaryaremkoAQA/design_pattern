package pattern.proxy.payment_app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pattern.proxy.payment_app.actions.IPay;
import pattern.proxy.payment_app.main_page_blocks.IOrderComponent;
import pattern.proxy.payment_app.main_page_blocks.OrderComponentProxy;
import pattern.proxy.payment_app.main_page_blocks.UserInformationBlock;

import java.util.Map;

public class PaymentScreenPage {

    private WebDriver driver;
    private UserInformationBlock userInformationBlock;
    private IOrderComponent orderComponent;
    protected IPay iPay;

    public PaymentScreenPage(final WebDriver driver) {
        this.driver = driver;
        this.userInformationBlock = PageFactory.initElements(driver, UserInformationBlock.class);
        this.orderComponent =new OrderComponentProxy(driver);
    }

    public void setPay(IPay iPay) {
        this.iPay = iPay;
        PageFactory.initElements(driver, this.iPay);
    }

    public void executePay(Map<String, String> payInfo) {
        iPay.pay(payInfo);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public IPay getPay() {
        return iPay;
    }

    public UserInformationBlock getUserInformationBlock() {
        return userInformationBlock;
    }

    public IOrderComponent getOrderComponent() {
        return this.orderComponent;
    }
}
