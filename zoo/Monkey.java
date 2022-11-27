public class Monkey extends Animal{

    Monkey(){
        super("Unnamed monkey", 2);
    }
    Monkey(String name){
        super(name, 2);
    }

    @Override
    public void move() {
        System.out.println(getName() + " walking with " + getWalkingLegs()
                + " and help with arms");
    }

    @Override
    public void eat() {
        System.out.println(getName() + ": Kikiki");
    }
}
