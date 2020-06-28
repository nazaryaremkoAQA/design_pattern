package pattern.test.decorator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pattern.decorator.DashboardPage;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(el -> Assert.assertTrue(el.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(el -> Assert.assertFalse(el.isDisplayed()));
    }

    private static final Consumer<DashboardPage> adminComponentShouldBePresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentShouldBeNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> superUserComponentShouldBeNotPresent = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> superUserComponentShouldBePresent = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> guestComponentShouldBePresent = (dp) -> shouldDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentShouldBeNotPresent = (dp) -> shouldNotDisplay(dp.getGuestComponents());

    private static final Consumer<DashboardPage> adminSelection = (user) -> user.selectRole("admin");
    private static final Consumer<DashboardPage> suSelection = (user) -> user.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection = (user) -> user.selectRole("guest");


    public static Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentShouldBePresent)
            .andThen(adminComponentShouldBeNotPresent).andThen(superUserComponentShouldBeNotPresent);

    public static Consumer<DashboardPage> adminPage = adminSelection.andThen(guestComponentShouldBePresent)
            .andThen(adminComponentShouldBePresent).andThen(superUserComponentShouldBePresent);

    public static Consumer<DashboardPage> suPage = suSelection.andThen(guestComponentShouldBePresent)
            .andThen(adminComponentShouldBeNotPresent).andThen(superUserComponentShouldBePresent);
}
