package pattern.template.php_travels.template_utils;

import pattern.template.php_travels.pages.PhpTravelHomePage;

import java.util.Map;

public abstract class Journey {

    public PhpTravelHomePage phpTravelHomePage;

    public abstract void launchSite();
    public abstract void searchItem(Map<String, String> information);

    public void search(Map<String, String> information){
        launchSite();
        searchItem(information);

    }

}
