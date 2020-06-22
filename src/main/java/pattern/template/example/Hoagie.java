package pattern.template.example;

public abstract class Hoagie {

    public void makeSandwich(){

        cutBun();

        if(isMeat()){
            addMeat();
        }

        if(isCheese()){
            addCheese();
        }
        addVegetables();
        addCondiments();
        wrapTheHoagie();
    }

    protected void cutBun(){
        System.out.println("Cut the bread");
    }

    protected void addMeat(){
        System.out.println("Add meat");
    }

    protected void addCheese(){
        System.out.println("Add cheese");
    }

    protected void addVegetables(){
        System.out.println("Add vegetables");
    }

    protected void addCondiments(){
        System.out.println("Add condimetns");
    }

    protected void wrapTheHoagie(){
        System.out.println("Wrap the hoagie");
    }

    protected abstract boolean isMeat();
    protected abstract boolean isCheese();
}
