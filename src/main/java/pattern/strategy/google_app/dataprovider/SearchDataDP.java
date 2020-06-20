package pattern.strategy.google_app.dataprovider;

import org.testng.annotations.DataProvider;
import pattern.strategy.google_app.actions.SpeechStrategy;
import pattern.strategy.google_app.actions.TextStrategy;
import pattern.strategy.google_app.strategy.GoogleSearchStrategy;

public class SearchDataDP {

    @DataProvider
    public Object[][] searchDataForGoogle() {

        return new Object[][]{
                new Object[]{
                        GoogleSearchStrategy.SPEECH, "Test Automation Guru", 10
                },
                new Object[]{
                        GoogleSearchStrategy.TEXT, "weather today", 9
                }
        };

    }
}
