public class Guest {

    private int money;
    Guest(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int m){
        money = m;
    }

    public void feed(String animal){
        Billing.feedOne(this, animal);
    }

    public void feedAll(){
        Billing.feedAll(this);
    }
}
