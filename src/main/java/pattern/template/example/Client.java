package pattern.template.example;

public class Client {

    public static void main(String[] args) {
        Hoagie hoagie = new ItalianHoagie();
        hoagie.makeSandwich();

        Hoagie hoagie1 = new VegetarianHoagie();
        hoagie1.makeSandwich();

    }
}
