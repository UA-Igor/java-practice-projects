import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Goods, Integer> cart = new HashMap<>();

    public void addToCart(Goods p, int qty){
        if (qty >= p.getCount()){
            cart.put(p, p.getCount());
        }
        else {
            cart.put(p, qty);
        }
    }

    public void removeFromCart(Goods p){
        if (cart.containsKey(p)) {
            cart.remove(p);
        }
        else{
            System.out.println("No such position in cart");
        }
    }

    public void changeQuantity(Goods p, int qty){
        if (isInCart(p)) {
            if ((cart.get(p) + qty) <= 0) {
                removeFromCart(p);
            } else {
                cart.replace(p, qty);
            }
        }
        else{
            System.out.println("No such position in cart");
        }
    }
    public void clearCart(){
        cart.clear();
    }

    public boolean isInCart(Goods p){
        return cart.containsKey(p);
    }

    public Map<Goods, Integer> getCart(){
        return cart;
    }
}
