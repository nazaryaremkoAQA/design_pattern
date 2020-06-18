package pattern.factory;

import org.openqa.selenium.WebDriver;

public interface IGoogleFactory {

    GooglePage createPage(WebDriver driver);
}
