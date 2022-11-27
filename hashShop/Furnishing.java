public class Furnishing extends Goods{
    Furnishing(){
        super("Chairs set");
    }
    Furnishing(String name){
        super(name);
    }

    public void useStaff() {
        System.out.println("PLace in your habitation new one");
    }
}