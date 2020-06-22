package pattern.template.php_travels.template_utils;

import org.openqa.selenium.WebDriver;
import pattern.template.php_travels.pages.PhpTravelHomePage;

import java.util.Map;

public class FlightsJourney extends Journey {

    @Override
    public void launchSite() {
        phpTravelHomePage.goTo();
    }

    public FlightsJourney(WebDriver driver) {
        this.phpTravelHomePage = new PhpTravelHomePage(driver);
    }


    @Override
    public void searchItem(Map<String, String> information) {
        phpTravelHomePage.getWait().until(d-> phpTravelHomePage.getHotelBlock().getHotels().isDisplayed());
        phpTravelHomePage.getFlightsBlock().getFlights().click();
        phpTravelHomePage.getFlightsBlock().setFrom(information.get("from"));
        phpTravelHomePage.getFlightsBlock().setTo(information.get("to"));
        phpTravelHomePage.getFlightsBlock().setDepart(information.get("depart"));
        phpTravelHomePage.getFlightsBlock().setSearchBtn();
    }


}
