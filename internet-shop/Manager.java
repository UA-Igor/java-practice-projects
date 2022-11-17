public class Manager {

    Goods ring = new Souvenir("Wedding ring");
    Goods sofa = new Furnishing("Sofa");
    Goods food = new Food();
    Goods cloth = new Clothes();

    public void fillWH(){
        Warehouse.addPosition(ring);
        Warehouse.addPosition(sofa);
        Warehouse.addPosition(food);
        Warehouse.addPosition(cloth);

        Warehouse.setQuantity(ring, 20);
        Warehouse.setQuantity(sofa, 15);
        for(int i = 0; i < 100; ++i){
            Warehouse.increasePosQty(food);
        }
        for(int i = 0; i < 50; ++i){
            Warehouse.increasePosQty(cloth);
        }
        ring.setPrice(1000);
        sofa.setPrice(400);
        food.setPrice(5);
        cloth.setPrice(100);
    }

}
