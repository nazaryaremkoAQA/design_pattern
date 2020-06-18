package pattern.factory;

import org.openqa.selenium.WebDriver;

public class EnglishFactory implements IGoogleFactory{

    @Override
    public GooglePage createPage(WebDriver driver) {
        return new GoogleEnglishPage(driver);
    }
}
