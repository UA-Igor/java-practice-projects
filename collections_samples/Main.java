/*
1. Реализовать свою структуру данных, не используя ничего
готового из collections framework. На вібор: ArrayList, LinkedList.
 Минимальній набор методов:
public boolean add(T data);
public boolean remove(int index);
public T get(int index);
public void print();
public boolean contains(T data);
2. Написать тесті для структурі данніх.
3*. Написать все структурі: ArrayList, LinkedList, Queue
 */

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(12);
        list.add(3334);
        list.add(342);
        list.add(34254343);
        list.add(300002);
        list.print();
        System.out.println("List contains 12 " + list.contains(12));
        System.out.println(list.remove(0));
        list.print();
        System.out.println("List contains 12 " + list.contains(12));
        System.out.println(list.remove(3));
        list.print();

        MyQueue<String> queue = new MyQueue<>();
        queue.put("First");
        queue.put("Second");
        queue.put("Third");
        queue.put("Fourth");
        System.out.println("Queue contains Third " + queue.contains("Third"));
        queue.print();
        String res = null;
        while(true){
            res = queue.get();
            if(res == null) break;
            System.out.println(res);
            System.out.println("Queue contains Third " + queue.contains("Third"));
        }
        queue.print();

        MyArrayList<Double> arr = new MyArrayList<>();
        arr.print();
        arr.add(3.25658);
        arr.add(5.64789798);
        arr.add(3.14);
        arr.add(5.0);
        arr.print();
        arr.printCapacity();
        System.out.println("Array contains 3.14 " + arr.contains(3.14));
        arr.remove(2);
        arr.print();
        System.out.println("Array contains 3.14 " + arr.contains(3.14));
        arr.print();

        for(int i = 0; i < 10000; ++i){
            arr.add((double)i);
        }
        arr.print();

        for(int i = 9000; i > 1000; --i){
            arr.remove(i);
        }

        arr.print();
        arr.printCapacity();
    }
}