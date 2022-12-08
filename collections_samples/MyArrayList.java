public class MyArrayList<T>{
    private Object[] array;
    private int capacity;
    private int actualCapacity;
    private int fillingFactor;
    private int hys;

    public MyArrayList(){
        capacity = 20;
        actualCapacity = 0;
        fillingFactor = 2;
        hys = ((capacity/10) > 3) ? capacity/10 : 3;
        array = new Object[capacity];
    }

    private void expand(){
        if(capacity < 200) {
            capacity *= 2;
        }
        else{
            capacity += 50;
        }
        Object[] tmp = new Object[capacity];
        System.arraycopy(array, 0, tmp, 0, actualCapacity);
        array = tmp;
        hys = ((capacity/10) > 3) ? capacity/10 : 3;
    }

    private void collapse(){
        if(actualCapacity > 100){
            capacity = actualCapacity + 50;
        }
        else {
            capacity = actualCapacity + 20;
        }
        Object[] tmp = new Object[capacity];
        System.arraycopy(array, 0, tmp, 0, actualCapacity);
        array = tmp;
        hys = ((capacity/10) > 3) ? capacity/10 : 3;
    }

    public boolean add(T data){
        if((actualCapacity > 0) && (capacity/actualCapacity < fillingFactor)){
            expand();
        }
        array[actualCapacity++] = data;
        return true;
    }

    public boolean remove(int index){
        if((index > (array.length - 1)) || (index > actualCapacity - 1)){
            return false;
        }
        System.arraycopy(array, index + 1, array, index, --actualCapacity - index);
        if((actualCapacity > 0) && ((capacity/(actualCapacity + hys)) > fillingFactor)){
            collapse();
        }
        return true;
    }
    public T get(int index){
        if((index > array.length - 1) || index < 0){
            return null;
        }
        else {
            return (T)array[index];
        }
    }
    public void print(){
        if(actualCapacity == 0){
            System.out.println("Array list is empty");
        }
        for(int i = 0; i < actualCapacity; ++i){
            System.out.print("[" + array[i].toString() + "]");
            if(i != 0 && i % 50 == 0){
                System.out.print('\n');
            }
        }
        System.out.print("\n\n");
    }

    public void printCapacity(){
        System.out.println("\nCapacity " + this.capacity + "\nActual capacity " + this.actualCapacity);
    }

    public boolean contains(T data){
        for(int i = 0; i < actualCapacity; ++i){
            if(array[i].equals(data)){
                return true;
            }
        }
        return false;
    }

}
