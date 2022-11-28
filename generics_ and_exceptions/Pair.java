public class Pair<K, V>{
    private K first;
    private V second;

    Pair(K first, V second){
        this.first = first;
        this.second = second;
    }

    public K getFirst(){
        return first;
    }

    public V getSecond(){
        return second;
    }
}
