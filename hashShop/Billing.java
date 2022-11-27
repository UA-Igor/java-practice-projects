import java.util.Map;
import java.util.Set;

public class Billing {
    private Customer customer;
    private Cart cart;
    private Map<Goods, Integer> goods;
    private Set<Goods> positionSet;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Billing billing = (Billing) o;

        if (!customer.equals(billing.customer)) return false;
        if (!cart.equals(billing.cart)) return false;
        if (!goods.equals(billing.goods)) return false;
        return positionSet.equals(billing.positionSet);
    }

    @Override
    public int hashCode() {
        int result = customer.hashCode();
        result = 31 * result + cart.hashCode();
        result = 31 * result + goods.hashCode();
        result = 31 * result + positionSet.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "customer=" + customer +
                ", cart=" + cart +
                ", goods=" + goods +
                ", positionSet=" + positionSet +
                '}';
    }
}
