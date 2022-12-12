import java.util.*;

public class MyHashSet<T>{

    private int cacheLength;
    private Object[] arr;
    private int[] elementsLength;
    private static final Object dummy = new Object();
    private final int TREEIFY_THRESHOLD = 8;
    private final int TREEIFY_COLLAPSE = 4;

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
            if(list.size() < TREEIFY_THRESHOLD){
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
                if(map.size() > TREEIFY_COLLAPSE){
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
        TreeMap<T, Object> map;
        for(Object x: arr){
            if(x != null) {
                if (x.getClass().getName().equals("java.util.LinkedList")) {
                    list = (LinkedList)x;
                    for(T t: list){
                        System.out.print("[" + t.toString() + "]");
                        if(i % 20 == 0){
                            System.out.print('\n');
                        }
                        ++i;
                    }
                }
                else{
                    map = (TreeMap<T, Object>)x;
                    for(T t: map.keySet()){
                        System.out.print("[" + t.toString() + "]");
                        if(i % 20 == 0){
                            System.out.print('\n');
                        }
                        ++i;
                    }
                }
            }
        }
    }

    public T get(int index){
        int pointer = 0;
        List<T> list;
        TreeMap<T, Object> map;
        for(Object x: arr){
            if(x != null) {
                //if index greater than list or map size in current array cell, skip it
                if (x.getClass().getName().equals("java.util.LinkedList")) {
                    list = (LinkedList)x;
                    if(index > list.size() - 1){
                        pointer = list.size() - 1;
                        continue;
                    }
                    for(T t: list){
                        if(pointer == index){
                            return t;
                        }
                        ++pointer;
                    }
                }
                else{
                    map = (TreeMap<T, Object>)x;
                    if(index > map.size() - 1){
                        pointer = map.size() - 1;
                        continue;
                    }
                    for(T t: map.keySet()){
                        if(pointer == index){
                            return t;
                        }
                        ++pointer;
                    }
                }

            }
        }
        return null;
    }
}
