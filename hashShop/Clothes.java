public class Clothes extends Goods{
    Clothes(){
        super("Jacket");
    }
    Clothes(String name){
        super(name);
    }

    public void useStaff() {
        System.out.println("Wear nice clothes");
    }
}