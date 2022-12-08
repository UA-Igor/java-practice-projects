public class MyQueue<T>{

    private Node<T> head;
    private Node<T> tail;

    public MyQueue(){
        this.head = null;
        this.tail = null;
    }

    public boolean put(T data){
        if(head == null && tail == null){
            head = new Node<>(null, data);
            tail = head;
        }
        else {
            Node<T> temp = new Node<>(null, data);
            tail.prev = temp;
            tail = temp;
        }
        return true;
    }

    public T get(){
        if (head != null && tail != null) {
            T data = head.current;
            head = head.prev;
            return data;
        }
        else {
            return null;
        }
    }

    public void print(){
        if(head == null){
            System.out.println("Queue is empty");
        }
        for(Node<T> x = head; x != null; x = x.prev){
            System.out.print("[" + x.current + "]");
        }
        System.out.println();
    }

    public boolean contains(T data){
        if(head == null && tail == null){
            return false;
        }
        for(Node<T> x = head; x != null; x = x.prev){
            if(x.current.equals(data)) {
                return true;
            }
        }
        return false;
    }

    private static class Node<T>{
        Node<T> prev;
        T current;
        Node(Node<T> prev, T current){
            this.prev = prev;
            this.current = current;
        }
    }
}
