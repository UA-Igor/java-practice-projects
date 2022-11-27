public class Horse extends Animal{

    Horse(){
        super("Unnamed horse", 4);
    }

    Horse(String name){
        super(name, 4);
    }

    @Override
    public void move() {
        System.out.println(getName() + " riding!");
    }

    @Override
    public void eat() {
        System.out.println(getName() + ": Igogo");
    }
}
