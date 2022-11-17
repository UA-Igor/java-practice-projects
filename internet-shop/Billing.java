import java.util.Map;
import java.util.Set;

public class Billing {
    private Customer customer;
    private Cart cart;
    Map<Goods, Integer> goods;
    Set<Goods> positionSet;
    Billing(Customer c){
        customer = c;
        cart = c.getCart();
        goods = cart.getCart();
        positionSet = goods.keySet();
    }

    public void buy(){
        int total = calculateTotal();
        if(customer.getMoney() >= total){
            customer.changeMoney(total);
            removeFromWH();
            System.out.println("Thank you! Have a nice day!");
        }
        else{
            System.out.println("Not enough money");
        }
    }

    private int calculateTotal(){
        int i = 0;
        for(Goods p: positionSet){
            i += p.getPrice() * goods.get(p);
        }
        return i;
    }

    private void removeFromWH(){
        for(Goods p: positionSet){
            Warehouse.setQuantity(p, -goods.get(p));
            if(p.getCount() == 0){
                Warehouse.removePosition(p);
            }
        }
    }

    public void showCart(){
        calculateTotal();
        for(Goods p: positionSet){
            System.out.println(p.getName() + " " + goods.get(p));
        }
        System.out.println("Total: " + calculateTotal());
        System.out.println("You have: " + customer.getMoney());
    }
}
