public class Bike extends Vehicle{
    Bike(){
        super("Common bike", 2, 2, 1);
    }

    Bike(String name, Construction type){
        super(name, type);
    }

    Bike(String name, int length, int wheels, int seats){
        super(name, length, wheels, seats);
    }

    public void move(){
        System.out.println("Ride your bike " + this.getName() + " with risk for life!");
    }


}
