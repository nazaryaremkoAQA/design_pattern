package pattern.template.example;

public class VegetarianHoagie extends Hoagie {

    @Override
    protected boolean isMeat() {
        return false;
    }

    @Override
    protected boolean isCheese() {
        return false;
    }
}
