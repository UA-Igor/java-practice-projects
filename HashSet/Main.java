/*
1. Реализовать свою структуру данных HashSet.
Минимальній набор методов:
*   public boolean add(T data);
*   public boolean remove(int index);
*   public T get(int index);
*   public void print();
*   public boolean contains(T data);

2. Написать тесті для структурі данніх.
 */

public class Main {
    public static void main(String[] args) {
        MyHashSet<Integer> set1 = new MyHashSet<>();
        Integer i = 565;
        System.out.println("Add 3242 " + set1.add(3242));
        System.out.println("Add 565 " + set1.add(i));
        System.out.println("Add 67575 " + set1.add(67575));
        System.out.println("Add 565 " + set1.add(i));
        System.out.println("Contains 565 " + set1.contains(i));
        System.out.println("Remove 565 " + set1.remove(i));
        set1.print();

        for(i = 100; i < 10_000; i += 50){
            set1.add(i);
        }

        set1.print();

        for(i = 0; i < 20; ++i){
            System.out.println(set1.get(i));
        }
    }
}