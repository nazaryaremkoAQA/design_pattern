package dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseDP {

    static List list = new ArrayList();
    static List listOflist = new ArrayList();

    public static Iterator<Object[]> multiListToListObject(List<List> items) {
        List<Object[]> data = new ArrayList();
        Iterator var2 = items.iterator();

        while(var2.hasNext()) {
            List list = (List)var2.next();
            data.add(0, list.toArray(new Object[list.size()]));
        }

        return data.iterator();
    }
}
