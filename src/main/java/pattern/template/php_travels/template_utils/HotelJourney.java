package pattern.template.php_travels.template_utils;

import org.openqa.selenium.WebDriver;
import pattern.template.php_travels.pages.PhpTravelHomePage;

import java.util.Map;

public class HotelJourney extends Journey {

    public HotelJourney(WebDriver driver) {
        this.phpTravelHomePage = new PhpTravelHomePage(driver);
    }

    @Override
    public void launchSite() {
        phpTravelHomePage.goTo();
    }

    @Override
    public void searchItem(Map<String, String> information) {
        phpTravelHomePage.getWait().until(d-> phpTravelHomePage.getHotelBlock().getHotels().isDisplayed());
        phpTravelHomePage.getHotelBlock().setHotels();
        phpTravelHomePage.getHotelBlock().setSearchBox(information.get("dest"));
        phpTravelHomePage.getHotelBlock().setCheckIn(information.get("checkIn"));
        phpTravelHomePage.getHotelBlock().setCheckOut(information.get("checkOut"));
        phpTravelHomePage.getHotelBlock().setSearchBtn();

    }
}
