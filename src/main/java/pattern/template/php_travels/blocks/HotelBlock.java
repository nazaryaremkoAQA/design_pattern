package pattern.template.php_travels.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pattern.template.shopping_app.pages.BasePage;
import utils.DatePicker;

import java.util.List;

public class HotelBlock extends BasePage {

    @FindBy(css = "a[href='#hotels']")
    private WebElement hotels;

    @FindBy(id = "s2id_autogen1")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchBoxField;

    @FindBy(id = "checkin")
    private WebElement checkIn;

    @FindBy(id = "checkout")
    private WebElement checkOut;

    @FindBy(xpath = "//button[@type= 'submit'and @class='btn btn-primary btn-block']")
    private List<WebElement> searchBtnList;

    public HotelBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, DatePicker.class);
    }

    public WebElement getHotels() {
        return hotels;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getCheckIn() {
        return checkIn;
    }

    public WebElement getCheckOut() {
        return checkOut;
    }

    public void setHotels() {
        this.hotels.click();
    }

    public void setSearchBox(String city) {
        By xpath = By.xpath(String.format("//span[text()='%s']", city));
        getWait().until(v-> searchBox.isDisplayed());
        this.searchBox.click();
        getWait().until(k -> searchBoxField.isDisplayed());
        this.searchBoxField.sendKeys(city);
        getWait().until(k -> getDriver().findElement(xpath).isDisplayed());
        this.getDriver().findElement(xpath).click();
    }

    public void setCheckIn(String day) {
        this.checkIn.click();
        By xpath = By.xpath(String.format("//div[@data-date='%s']", day));
        getWait().until(k -> getDriver().findElement(xpath).isDisplayed());
        getDriver().findElement(xpath).click();
    }

    public void setCheckOut(String day) {
        this.checkOut.click();
        By xpath = By.xpath(String.format("(//div[@data-date='%s' and  @data-year='2020'])[2]", day));
        getWait().until(k -> getDriver().findElement(xpath).isDisplayed());
        getDriver().findElement(xpath).click();
    }

    public void setSearchBtn() {
        for (WebElement el:searchBtnList) {
            try{
                el.click();
            }catch (Exception ex){

            }
        }
     }
}
