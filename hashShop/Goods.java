public abstract class Goods {
    private int count;
    private int price;
    private final String name;
    Goods(String name){
        count = 0;
        price = 0;
        this.name = name;
    }

    public abstract void useStaff();

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void addCount(){
        ++count;
    }

    public void subCount(){
        if (count == 0){
            return;
        }
        else {
            --count;
        }
    }

    public int getCount(){
        return count;
    }

    public void setCount(int i){
        if(i == 0){
            count = 0;
        }
        if (i < 0){
            for(int k = i; k < 0; ++k){
                subCount();
            }
        }
        if (i > 0){
            for(int k = 0; k < i; ++k){
                addCount();
            }
        }
    }

    public void setPrice(int i){
        price = i;
    }

    @Override
    public String toString(){
        return "Name: " + getName() + ", Price: " + getPrice() + ", Quantity: " + getCount();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        else if (obj != null
                    && (obj instanceof Goods gs)
                    && (gs.name == this.name)
                    && (gs.price == this.price)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 31*(price + (name != null ? name.hashCode() : 0));
    }

}
