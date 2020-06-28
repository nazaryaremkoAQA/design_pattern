package pattern.test.decorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pattern.decorator.DashboardPage;
import test.base.BaseTest;

import java.util.function.Consumer;

public class DecoratorTest extends BaseTest {

    private DashboardPage page;

    @BeforeTest
    public void prepare() {
        this.page = new DashboardPage(driver);
    }

    @Test(dataProvider = "getData")
    public void decoratorTest(Consumer<DashboardPage> pageConsumer) {
        this.page.goTo();
        pageConsumer.accept(this.page);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Decorators.guestPage,
                Decorators.adminPage,
                Decorators.suPage,

        };
    }
}
