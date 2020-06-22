package pattern.template.php_travels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pattern.template.php_travels.blocks.FlightsBlock;
import pattern.template.php_travels.blocks.HotelBlock;
import pattern.template.shopping_app.pages.BasePage;

public class PhpTravelHomePage extends BasePage {

    private FlightsBlock flightsBlock;
    private HotelBlock hotelBlock;

    public PhpTravelHomePage(WebDriver driver) {
        super(driver);
        flightsBlock = new FlightsBlock(driver);
        hotelBlock = new HotelBlock(driver);
        setWait(new WebDriverWait(driver, 15));
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.getDriver().get("https://www.phptravels.net/home");
    }

    public FlightsBlock getFlightsBlock() {
        return flightsBlock;
    }

    public HotelBlock getHotelBlock() {
        return hotelBlock;
    }
}
