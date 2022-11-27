public class Zoo {
    private Animal[] allAnimals;
    private static int price;

    Zoo(){
        Animal[] a =  {new Monkey("Sarah"),
                      new Horse("Anatoliy"),
                      new Kangaroo("Kenga"),
                      new Monkey("Olha")};
        this.allAnimals = a;
        this.price = 100;
    }

    public static void setPrice(int price){
        Zoo.price = price;
    }

    public static int getPrice(){
        return Zoo.price;
    }

    public void feeding(String animal){
        for (Animal a: allAnimals){
            String type = a.getClass().getName();
            if (type.equals(animal)){
                System.out.print(type + ' ');
                a.eat();
                return;
            }
        }
        System.out.println("No such animal in the zoo");
    }

    public void feedingAll(){
        for (Animal a: allAnimals){
            System.out.print(a.getClass().getName() + ' ');
            a.eat();
        }
    }

    public Animal[] getAnimals(){
        return allAnimals;
    }
}
