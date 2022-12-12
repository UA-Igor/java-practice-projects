import java.util.*;

public class MyHashSet<T>{

    private int cacheLength;
    private Object[] arr;
    private static final Object dummy = new Object();
    private final int TREEFY_THRESHOLD = 8;
    private final int TREEFY_COLLAPSE = 4;

    MyHashSet(){
        this.cacheLength = 20;
        arr = new Object[cacheLength];
    }

    MyHashSet(int cacheLength){
        this.cacheLength = cacheLength;
        arr = new Object[cacheLength];
    }

    public boolean add(T data){
        //checking for unique object
        if(contains(data)){
            return false;
        }
        int collapsedHash = data.hashCode() % cacheLength;
        //initial of array cell
        if(arr[collapsedHash] == null){
            List<T> list = new LinkedList<>();
            list.add(data);
            arr[collapsedHash] = list;
            return true;
        }
        else if(arr[collapsedHash].getClass().getName().equals("java.util.LinkedList")){
            List<T> list = (LinkedList<T>)arr[collapsedHash];
            if(list.size() < TREEFY_THRESHOLD){
                return list.add(data);
            }
            else{
                list.add(data);
                arr[collapsedHash] = treefy(list);
                return true;
            }
        }
        else {
            TreeMap<T, Object> map = (TreeMap)arr[collapsedHash];
            map.put(data, dummy);
            return true;
        }
    }

    private TreeMap<T, Object> treefy(List<T> list){
        TreeMap<T, Object> map = new TreeMap<>();
        for(T l: list){
            map.put(l, dummy);
        }
        return map;
    }

    public boolean contains(T data){
        int collapsedHash = data.hashCode() % cacheLength;
        if(arr[collapsedHash] != null){
            if(arr[collapsedHash].getClass().getName().equals("java.util.LinkedList")){
                List<T> list = (LinkedList)arr[collapsedHash];
                return list.contains(data);
            }
            else if(arr[collapsedHash].getClass().getName().equals("java.util.TreeMap")){
                TreeMap<T, Object> map = (TreeMap)arr[collapsedHash];
                return map.containsKey(data);
            }
        }
        return false;
    }

    public boolean remove(T data){
        if(!contains(data)){
            return false;
        }
        int collapsedHash = data.hashCode() % cacheLength;
        if(arr[collapsedHash] != null){
            if(arr[collapsedHash].getClass().getName().equals("java.util.LinkedList")){
                List<T> list = (LinkedList)arr[collapsedHash];
                return list.remove(data);
            }
            else if(arr[collapsedHash].getClass().getName().equals("java.util.TreeMap")){
                TreeMap<T, Object> map = (TreeMap)arr[collapsedHash];
                if(map.size() > TREEFY_COLLAPSE){
                    map.remove(data);
                    return true;
                }
                else{
                    List<T> list = listing(map);
                    arr[collapsedHash] = list;
                    return list.remove(data);
                }
            }
        }
        return false;
    }

    private List<T> listing(TreeMap<T, Object> map){
        List<T> list = new LinkedList<>();
        for(T m: map.keySet()){
            list.add(m);
        }
        return list;
    }

    public void print(){
        int i = 0;
        List<T> list;
        for(Object x: arr){
            if(x != null) {
                if (x.getClass().getName().equals("java.util.LinkedList")) {
                    list = (LinkedList)x;
                }
                else{
                    list = listing((TreeMap<T, Object>)x);
                }
                for(T t: list){
                    System.out.print("[" + t.toString() + "]");
                    if(i % 20 == 0){
                        System.out.print('\n');
                    }
                    ++i;
                }
            }
        }
    }

    public T get(int index){
        int i = 0;
        List<T> list;
        for(Object x: arr){
            if(x != null) {
                if (x.getClass().getName().equals("java.util.LinkedList")) {
                    list = (LinkedList)x;
                }
                else{
                    list = listing((TreeMap<T, Object>)x);
                }
                for(T t: list){
                    if(i == index){
                        return t;
                    }
                    ++i;
                }
            }
        }
        return null;
    }
}