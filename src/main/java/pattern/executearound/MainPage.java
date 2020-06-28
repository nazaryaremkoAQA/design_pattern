package pattern.executearound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

import static org.openqa.selenium.support.PageFactory.*;


public class MainPage {

    private final WebDriver driver;

    @FindBy(id="a")
    private WebElement a;

    @FindBy(id="b")
    private WebElement b;

    @FindBy(id="c")
    private WebElement c;

    private FrameA frameA;
    private FrameB frameB;
    private FrameC frameC;

    public MainPage(WebDriver driver){
        this.driver = driver;
        initElements(driver, this);
        this.frameA = initElements(driver, FrameA.class);
        this.frameB = initElements(driver, FrameB.class);
        this.frameC = initElements(driver, FrameC.class);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    public void onFrameA(Consumer<FrameA> consumer){
        this.driver.switchTo().frame(a);
        consumer.accept(this.frameA);
        this.driver.switchTo().defaultContent();
    }

    public void onFrameB(Consumer<FrameB> consumer){
        this.driver.switchTo().frame(b);
        consumer.accept(this.frameB);
        this.driver.switchTo().defaultContent();
    }

    public void onFrameC(Consumer<FrameC> consumer){
        this.driver.switchTo().frame(c);
        consumer.accept(this.frameC);
        this.driver.switchTo().defaultContent();
    }

}
