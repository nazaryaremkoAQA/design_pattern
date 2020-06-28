package pattern.proxy.payment_app.main_page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentReal implements IOrderComponent {

    @FindBy(id = "buy")
    private WebElement buy;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public OrderComponentReal(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @Override
    public String placeOrder() {
        this.buy.click();
        return this.orderNumber.getText();
    }
}
