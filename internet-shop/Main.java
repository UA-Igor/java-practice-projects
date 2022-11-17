/*
Спроектировать систему классов для интернет-магазина.
Покупатель может иметь n денежных средств, n купленных
товаров, корзину с зарезервированными товарами.
Товары бывают разных категорий(продовольствие, одежда, мебель, сувениры),
каждый товар представлен в  магазине в фиксированном кол-ве.

Система должна позволять:

1. Обращаться человеку в магазин с запросом на получение ассортимента/покупку n-го количества товаров.
2. Позволять заведующему магазина добавлять/убирать товары со склада.
3. При оформлении заказа пользователем перенаправлять на систему оплаты - она
показывает список заказанных товаров из корзины и при подтверждении пользователем
совершает покупку(при условии достаточности средств на счету пользователя)
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Manager alex = new Manager();
        alex.fillWH();
        System.out.println("WH before:");
        for (Goods p :Warehouse.getGoodsList()){
            System.out.println("Name: " + p.getName() + ", Price: " + p.getPrice() + ", Quantity: " + p.getCount());
        }
        Customer tom = new Customer(38000);
        List<Goods> list = tom.getList();
        for (Goods p: list){
            if(p.getName().equals("Wedding ring")){
                tom.addToCart(p.getName(), 3);
            }
            else if(p.getName().equals("Sofa")){
                tom.addToCart(p.getName(), 4);
            }
            else if(p.getName().equals("Pizza")){
                tom.addToCart(p.getName(), 10);
            }
            else if(p.getName().equals("Jacket")){
                tom.addToCart(p.getName(), 20);
            }
        }
        tom.payBill();

        System.out.println("WH after:");
        for (Goods p :Warehouse.getGoodsList()){
            System.out.println("Name: " + p.getName() + ", Price: " + p.getPrice() + ", Quantity: " + p.getCount());
        }
    }
}