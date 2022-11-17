import java.util.List;
import java.util.Scanner;

public class Customer {
    private int money;
    private Cart cart = new Cart();
    private List<Goods> list;
    Customer(int money){
        this.money = money;
    }

    private void obtainList(){
        list = Warehouse.getGoodsList();
    }

    public List<Goods> getList(){
        if (list == null){
           obtainList();
        }
        return list;
    }

    public int getMoney(){
        return money;
    }

    public void changeMoney(int i){
        money += i;
    }

    public Cart getCart(){
        return cart;
    }

    public void addToCart(Goods p, int qty){
        addToCart(p.getName(), qty);
    }

    public void addToCart(String s, int qty){
        for (Goods p: list){
            if (p.getName().equals(s)){
                cart.addToCart(p, qty);
                return;
            }
        }
        System.out.println("No such position");
    }

    public void removeFromCart(Goods p){
        removeFromCart(p.getName());
    }

    public void removeFromCart(String s){
        for (Goods p: list){
            if (p.getName().equals(s)){
                cart.removeFromCart(p);
                return;
            }
        }
    }

    public void clearCart(){
        cart.clearCart();
    }

    public void changeQuantity(Goods p, int qty){
        changeQuantity(p.getName(), qty);
    }

    public void changeQuantity(String s, int qty){
        for (Goods p: list){
            if (p.getName().equals(s)){
                cart.changeQuantity(p, qty);
                return;
            }
        }
    }

    public void payBill(){
        Billing bill = new Billing(this);
        Scanner sc = new Scanner(System.in);
        bill.showCart();
        System.out.println("Are you shure to buy it?");
        if(sc.next().equals("y")){
            bill.buy();
        }
        sc.close();
    }
}
