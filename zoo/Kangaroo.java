public class Kangaroo extends Animal{

    Kangaroo(){
        super("Unnamed kangaroo", 2);
    }
    Kangaroo(String name){
        super(name, 2);
    }

    @Override
    public void move() {
        System.out.println(getName() + " jumping on " + getWalkingLegs() + " legs");
    }

    @Override
    public void eat() {
        System.out.println(getName() + ": Yammy!");
    }
}
