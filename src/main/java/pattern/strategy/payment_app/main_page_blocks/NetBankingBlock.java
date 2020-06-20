package pattern.strategy.payment_app.main_page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NetBankingBlock extends AbstractComponent {

    @FindBy(id = "bank")
    private WebElement bank;

    @FindBy(id = "acc_number")
    private WebElement account;

    @FindBy(id = "pin")
    private WebElement pin;

    public NetBankingBlock(WebDriver driver) {
        super(driver);
    }

    public void fillOutBankingInfo(String bankName, String account, String pin) {
        this.wait.until((d) -> this.bank.isDisplayed());
        Select drpBank = new Select(this.bank);
        drpBank.selectByVisibleText(bankName);
        this.account.sendKeys(account);
        this.pin.sendKeys(pin);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.bank.isDisplayed());
    }
}
