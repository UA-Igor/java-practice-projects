public class Souvenir extends Goods{
    Souvenir(){
        super("Pocket watch");
    }
    Souvenir(String name){
        super(name);
    }

    @Override
    public void useStaff() {
        System.out.println("Enjoy with unique thing");
    }
}