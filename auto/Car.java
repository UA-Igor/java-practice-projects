public class Car extends Vehicle{
    Car(){
        super("Common car", 3, 4, 4);
    }

    Car(String name, Construction type){
        super(name, type);
    }

    Car(String name, int length, int wheels, int seats){
        super(name, length, wheels, seats);
    }

    public void move(){
        System.out.println("Ride your new " + this.getName());
    }
}
