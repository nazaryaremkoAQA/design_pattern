package pattern.strategy.payment_app.main_page_blocks;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderBlock extends AbstractComponent{

    @FindBy(id = "buy")
    private WebElement buy;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    @Override
    public boolean isDisplayed() {
        return this.wait.until((Function<? super WebDriver, Boolean>) (d) -> this.orderNumber.isDisplayed());
    }

    public OrderBlock(WebDriver driver) {
        super(driver);
     }

    public String getOrder(){
        this.buy.click();
        return this.orderNumber.getText();
    }
}
