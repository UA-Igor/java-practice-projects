import java.util.LinkedList;
import java.util.List;

public final class Warehouse {
    private static List<Goods> goodsList = new LinkedList<>();
    private Warehouse(){

    }

    public static void addPosition(Goods p){
        goodsList.add(p);
    }

    public static void removePosition(Goods p){
        if (goodsList.contains(p)){
            goodsList.remove(p);
        }
    }

    public static List<Goods> getGoodsList(){
        return goodsList;
    }

    public static void increasePosQty(Goods p){
        p.addCount();
    }

    public static void decreasePosQty(Goods p){
        if (p.getCount() <= 0){
            System.out.println("Quantity can't be less than 0");
        }
        else {
            p.subCount();
        }
    }

    public static void setQuantity(Goods p, int i){
        if (p.getCount() + i < 0){
            System.out.println("Stored goods: " + p.getCount() +
                    " can't be changed with " + i);
        }
        else {
            p.setCount(i);
        }
    }
}
