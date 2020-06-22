package pattern.template.shopping_app.template_utils;

public abstract class ShoppingTemplate {

    public abstract void launchSite();
    public abstract void searchItem();
    public abstract void selectProduct();
    public abstract String buy();

    public String shop(){
        launchSite();
        searchItem();
        selectProduct();
        return buy();
    }

}
