package pattern.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {

    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        boolean displayed = this.dismissalAlert.isDisplayed();
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean isNotdisplayed = false;
        try {
            isNotdisplayed = this.dismissalAlert.isDisplayed();
        } catch (Exception e) {

        }
        return displayed && !isNotdisplayed;
    }
}
