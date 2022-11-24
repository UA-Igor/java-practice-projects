/*
1. Создать систему типов для реализации доменной области "автосалон".
В салоне могут находиться автомобили разных типов с уникальными характерными особенностями.
При реализации использовать как композицию, так и наследование.
2. Для одного из типов нашей системы переопределить toString, equals, hashCode собственноручно(без автогенерации).
3. Для всех остальных типов то же, что и в 2, но с автогенерацией.
 */

public class Main {
    public static void main(String[] args) {
        Construction custom = new Construction(3, 3, 2);
        Vehicle limousine = new Car("Ford", 5, 6, 10);
        Vehicle corvette = new Car("Audi", 3, 4, 4);
        Vehicle mitsubishi = new Bike("Mitsibisi", 3, 2, 2);
        Vehicle strangeCar = new Car("CityToy", custom);
        Vehicle quadro = new Bike("Quadro", 4, 4, 2);
        Vehicle anotherQuadro = new Bike("Quadro", 4, 4, 2);
        Vehicle bike = new Bike();

        System.out.println("Is equals? " + quadro.equals(anotherQuadro)
                + " | And vice versa? " + anotherQuadro.equals(quadro));

        SellingArea.addVehicle(limousine);
        SellingArea.addVehicle(corvette);
        SellingArea.addVehicle(mitsubishi);
        SellingArea.addVehicle(strangeCar);
        SellingArea.addVehicle(quadro);
        SellingArea.addVehicle(anotherQuadro);
        SellingArea.addVehicle(bike);

        for (Vehicle v: SellingArea.getVehiclesList()){
            System.out.println(v);
            System.out.println(v.hashCode());
            System.out.println();
        }

        SellingArea.removeVehicle(bike);
        SellingArea.removeVehicle(corvette);
        System.out.println("-----------------------------------------------------------------------------");

        for (Vehicle v: SellingArea.getVehiclesList()){
            System.out.println(v);
            System.out.println(v.hashCode());
            System.out.println();
        }

    }
}