/*
1. Написать класс Pair, который будет содержать два поля разных типов.
Класс должен работать с любой парой типов.
2. Написать примеры программ, которые
2.1 Выбрасывает NullPointerException
2.2 Выбрасывает ArrayIndexOutOfBoundsException (когда запрашиваете из массива по несуществующему номеру ячейки)
2.3 Выбрасывает ClassCastExcetpion(когда делаете неправильное явное приведение типа).
 */

public class Main {
    public static void main(String[] args) {

        ExceptionThrower except = new ExceptionThrower();

        System.out.println(except.findWithIndex(new Number[]{1,2,3,4}, 0));
        try {
            System.out.println(except.findWithIndex(new Number[]{1, 2, 3, 4}, 4));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(except.findWithIndex(new Number[]{1, 2, 3, 4}, -1));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        Object obj = null;
        try{
            Object newObj = except.returnItself(obj);
            System.out.println(newObj);
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        obj = "My string";

        try{
            Object newObj = except.returnItself(obj);
            System.out.println(newObj);
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        try{
            except.switcher(obj);
            System.out.println(obj.getClass().getName() + " successfully casted");
        }
        catch (ClassCastException e){
            System.out.println(e.getMessage());
        }

        try{
            except.switcher(except);
            System.out.println(except.getClass().getName() + " successfully casted");
        }
        catch (ClassCastException e){
            System.out.println(e.getMessage());
        }

        Pair firstPairing = new Pair("Another my string", 15);
        System.out.println(firstPairing.getFirst() + " " + firstPairing.getSecond());

        Pair secondPairing = new Pair(23.5, "And another");
        System.out.println(secondPairing.getFirst() + " " + secondPairing.getSecond());
    }
}