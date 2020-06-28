package pattern.proxy.payment_app.main_page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInformationBlock extends AbstractComponent {

    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    public UserInformationBlock(WebDriver driver) {
        super(driver);
    }


    public void enterUserInfo(String fN, String lN, String mail){
        this.wait.until((d) -> this.firstName.isDisplayed());

        firstName.sendKeys(fN);
        lastName.sendKeys(lN);
        email.sendKeys(mail);

    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.firstName.isDisplayed());
    }
}
