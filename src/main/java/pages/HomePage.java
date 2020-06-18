package pages;

import org.openqa.selenium.By;

public class HomePage{

    private String pageUrl = "https://skyronic.github.io/vue-spa/#/";
    private By products = By.xpath("//span[@class='price']/../a");
    private By iPadMini = By.xpath("//span[@class='price']/../a[contains(text(),'iPad 4 Mini')]");
    private By price = By.xpath("//span[@class='price']");
    private By home = By.xpath("//a[@class='router-link-active']");

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public By getProducts() {
        return products;
    }

    public void setProducts(By products) {
        this.products = products;
    }

    public By getPrice() {
        return price;
    }

    public void setPrice(By price) {
        this.price = price;
    }

    public By getHome() {
        return home;
    }

    public void setHome(By home) {
        this.home = home;
    }

    public By getiPadMini() {
        return iPadMini;
    }

    public void setiPadMini(By iPadMini) {
        this.iPadMini = iPadMini;
    }
}
