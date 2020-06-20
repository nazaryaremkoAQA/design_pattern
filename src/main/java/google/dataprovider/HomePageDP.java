package google.dataprovider;


import org.testng.annotations.DataProvider;

import java.util.*;

public class HomePageDP extends BaseDP {

    @DataProvider()
    public Iterator<Object[]> getProducts() {

        List<String> productsName = new ArrayList<>();
        productsName.add("iPad 4 Mini");
        productsName.add("H&M T-Shirt White");
        productsName.add("Charli XCX - Sucker CD");

        List<String> productsPrice = new ArrayList<>();
        productsPrice.add("$ 500.01");
        productsPrice.add("$ 10.99");
        productsPrice.add("$ 19.99");


        list.add(productsName);
        list.add(productsPrice);
        listOflist.add(list);


        return multiListToListObject(listOflist);

    }

}
