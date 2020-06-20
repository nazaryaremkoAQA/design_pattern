package pattern.strategy.emirates.dataprovider;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import pattern.strategy.emirates.strategy.EmiratesSearchStrategy;

import java.util.HashMap;
import java.util.Map;

public class SearchDataDP {

    private WebDriver driver;

    @DataProvider
    public Object[][] searchDataForEmirates() {

        Map<String, String> map = new HashMap<>();
        map.put("departureCity", "Austin (AUS)");
        map.put("arrivalCity", "Houston (IAH)");
        map.put("arrivalCity2", "Las Vegas (LAS)");

        return new Object[][]{
                new Object[]{
                        EmiratesSearchStrategy.ONE_WAY, map
                },
                new Object[]{
                        EmiratesSearchStrategy.RETURN, map
                },
                new Object[]{
                        EmiratesSearchStrategy.ADVANCED, map
                },
        };

    }
}
