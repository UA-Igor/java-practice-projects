import java.util.Objects;

public abstract class Vehicle {
    private String name;
    private final Construction type;

    Vehicle(String name, Construction type){
        this.name = name;
        this.type = type;
    }

    Vehicle(String name, int length, int wheels, int seats){
        this(name, new Construction(length, wheels, seats));
    }

    public abstract void move();

    public String getName(){
        return this.name;
    }

    public Construction getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return name.equals(vehicle.name) && type.equals(vehicle.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
