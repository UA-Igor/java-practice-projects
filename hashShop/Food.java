public class Food extends Goods{
    Food(){
        super("Pizza");
    }
   Food(String name) {
       super(name);
   }

    public void useStaff() {
        System.out.println("Eat delicious food");
    }
}