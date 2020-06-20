package pattern.strategy.google_app.strategy;

import org.openqa.selenium.WebDriver;
import pattern.strategy.google_app.actions.ISearchStrategy;
import pattern.strategy.google_app.actions.SpeechStrategy;
import pattern.strategy.google_app.actions.TextStrategy;

public enum GoogleSearchStrategy {

    TEXT {
        public ISearchStrategy action(WebDriver driver) {
            return new TextStrategy(driver);
        }
    },
    SPEECH {
        public ISearchStrategy action(WebDriver driver) {

            return new SpeechStrategy(driver);
        }
    };

    public abstract ISearchStrategy action(WebDriver driver);

}
