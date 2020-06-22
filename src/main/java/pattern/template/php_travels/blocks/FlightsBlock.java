package pattern.template.php_travels.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pattern.template.shopping_app.pages.BasePage;

import java.util.List;

public class FlightsBlock extends BasePage {

    @FindBy(css = "a[href='#flights']")
    private WebElement flights;

    @FindBy(id = "s2id_location_from")
    private WebElement from;

    @FindBy(id = "s2id_location_to")
    private WebElement to;

    @FindBy(id = "FlightsDateStart")
    private WebElement depart;

    @FindBy(xpath = "(//div[@id='chat-widget-container']/following-sibling::div//input)")
    private List<WebElement> listToInputs;

    @FindBy(xpath = "//div[@id='select2-drop']//input[@type='text']")
    private WebElement fromInput;

    @FindBy(xpath = "//button[@type= 'submit']")
    private List<WebElement> searchBtnList;

    public FlightsBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getFlights() {
        return flights;
    }

    public WebElement getFrom() {
        return from;
    }

    public WebElement getTo() {
        return to;
    }

    public WebElement getDepart() {
        return depart;
    }

    public void setFrom(String from) {
        By xpath = By.xpath(String.format("//span[text()='%s']", from));

        getWait().until(k -> this.from.isDisplayed());
        this.from.click();
        getWait().until(k -> this.fromInput.isDisplayed());
        this.fromInput.sendKeys(from);

        getWait().until(k -> getDriver().findElement(xpath).isDisplayed());
        this.getDriver().findElement(xpath).click();

    }

    public void setTo(String to) {

        By xpath = By.xpath(String.format("//span[text()='%s']", to));

        getWait().until(k -> this.to.isDisplayed());
        this.to.click();

        for (WebElement el : listToInputs) {
            try {
                el.sendKeys(to);
                System.out.println(el.isDisplayed());

            } catch (Exception ex) {
            }

        }

        getWait().until(k -> getDriver().findElement(xpath).isDisplayed());
        this.getDriver().findElement(xpath).click();
    }

    public void setDepart(String day) {
        this.depart.click();
        By allXpath = By.xpath(String.format("(//div[@data-date='%s' and  @data-year='2020'])", day));

        List<WebElement> elements = getDriver().findElements(allXpath);

        for (int i = 0; i < elements.size(); i++) {
            try {
                By xpath = By.xpath(String.format("(//div[@data-date='%s' and  @data-year='2020'])[%s]", day, i));
                getDriver().findElement(xpath).click();
            } catch (Exception ex) {

            }
        }
    }

    public void setSearchBtn() {
        for (WebElement el : searchBtnList) {
            try {
                el.click();
            } catch (Exception ex) {

            }
        }
    }


}
