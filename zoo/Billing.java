public class Billing {
    private static Zoo zoo = new Zoo();

    public static void feedOne(Guest gst, String animal){
        int remain = gst.getMoney() - Zoo.getPrice();
        if (remain >= 0){
            gst.setMoney(remain);
            zoo.feeding(animal);
        }
        else{
            System.out.println("Not enough money for feeding");
        }
    }

    public static void feedAll(Guest gst){
        int remain = gst.getMoney() - zoo.getAnimals().length * Zoo.getPrice();
        if(remain >= 0){
            gst.setMoney(remain);
            zoo.feedingAll();
        }
        else {
            System.out.println("Not enough money to feed all animals");
        }
    }
}
