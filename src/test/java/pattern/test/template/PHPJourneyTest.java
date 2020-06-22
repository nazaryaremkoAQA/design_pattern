package pattern.test.template;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pattern.template.php_travels.pages.PhpTravelHomePage;
import pattern.template.php_travels.template_utils.FlightsJourney;
import pattern.template.php_travels.template_utils.HotelJourney;
import pattern.template.php_travels.template_utils.Journey;
import test.base.BaseTest;

import java.util.HashMap;
import java.util.Map;

public class PHPJourneyTest extends BaseTest {

    private PhpTravelHomePage travelHomePage;

    @BeforeTest
    public void set() {
        travelHomePage = new PhpTravelHomePage(driver);
    }

    @Test(dataProvider = "journeyData")
    public void phpJourneyTest(Journey journey, Map<String, String> journeyData) {
        journey.search(journeyData);
    }

    @DataProvider
    public Object[][] journeyData() {

        Map<String, String> hotelData = new HashMap<>();
        hotelData.put("dest", "London");
        hotelData.put("checkIn", "24");
        hotelData.put("checkOut", "26");

        Map<String, String> flyData = new HashMap<>();
        flyData.put("depart", "28");
        flyData.put("to", "London");
        flyData.put("from", "Paris");

        return new Object[][]{
                new Object[]{
                        new HotelJourney(driver), hotelData
                },
                new Object[]{
                        new FlightsJourney(driver), flyData
                }
        };

    }

}
