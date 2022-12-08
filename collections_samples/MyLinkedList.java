public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> current;

    public MyLinkedList(){
        this.first = null;
        this.current = null;
    }

    public boolean add(T data){
        if(first == null) {
            first = new Node<>(null, data, null);
            current = first;
        }
        else{
            Node<T> newNode = new Node<>(current, data, null);
            current.next = newNode;
            current = newNode;
        }
        return true;
    }

    public boolean remove(int index){
        if(first == null){
            return false;
        }
        if(index == 0 && first.next == null){
            first = null;
            return true;
        }
        int i = 0;
        for(Node<T> x = first; x != null; x = x.next){
            if(i == index){
                if(x.next == null){
                    x.prev.next = null;
                    return true;
                }
                //If removing first node and it's not a single element
                else if(x.prev == null){
                    x.next.prev = null;
                    first = x.next;
                    return true;
                }
                else{
                    x.prev.next = x.next;
                    x.next.prev = x.prev;
                    return true;
                }
            }
            ++i;
        }
        return false;
    }

    public T get(int index){
        int i = 0;
        for(Node<T> x = first; x != null; x = x.next){
            if(i == index){
                return x.current;
            }
        }
        return null;
    }

    public void print(){
        if(first == null){
            System.out.println("List is empty");
        }
        for(Node<T> x = first; x != null; x = x.next){
            System.out.print("[" + x.current.toString() + "]");
        }
        System.out.println();
    }

    public boolean contains(T data){
        Node<T> node = first;
        while (node.next != null){
            if(node.current.equals(data)){
                return true;
            }
            else{
                node = node.next;
            }
        }
        return false;
    }

    private static class Node<T>{
        Node<T> prev;
        T current;
        Node<T> next;

        Node(Node<T> prev, T current, Node<T> next){
            this.prev = prev;
            this.current = current;
            this.next = next;
        }
    }
}
