package pattern.template.example;

public class ItalianHoagie extends Hoagie {

    String [] meat = {"pork", "prosciutto"};
    String [] cheese = {"mozzarella"};
    String [] vegetables = {"onion","tomato"};
    String [] condiments = {"oil","paper"};

    @Override
    protected boolean isMeat() {
        return true;
    }

    @Override
    protected void addCheese(){
        for (String cheese: cheese) {
            System.out.println("Cheese "+ cheese);

        }
    }


    @Override
    protected boolean isCheese() {
        return true;
    }
}
