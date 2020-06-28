package pattern.proxy.payment_app.main_page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayPalBlock extends AbstractComponent {

    @FindBy(id = "paypal_username")
    private WebElement payPalUserName;

    @FindBy(id = "paypal_password")
    private WebElement payPalPassword;

    public PayPalBlock(WebDriver driver) {
        super(driver);
    }

    public void fillOutPayPalInfo(String payPalUserName, String payPalPassword){
        this.wait.until((d) -> this.payPalUserName.isDisplayed());
        this.payPalUserName.sendKeys(payPalUserName);
        this.payPalPassword.sendKeys(payPalPassword);

    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.payPalUserName.isDisplayed());
    }
}
