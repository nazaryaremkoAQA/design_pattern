package pattern.strategy.google_app.actions;

public interface ISearchStrategy {
    void search(String searchFor) throws InterruptedException;
}
