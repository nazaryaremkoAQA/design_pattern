package pattern.command;

import org.openqa.selenium.WebElement;

public class NotificationValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;

    public NotificationValidator(final WebElement button, final WebElement notification) {
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        this.button.click();
        boolean apperanceState = this.notification.isDisplayed();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean disapperanceState = this.notification.isDisplayed();
        return apperanceState && !disapperanceState;
    }
}
