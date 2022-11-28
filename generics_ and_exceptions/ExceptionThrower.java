public class ExceptionThrower {

    public Object returnItself(Object o) throws NullPointerException{
        if(o != null){
            return o;
        }
        else {
            throw new NullPointerException("Your object is null");
        }
    }

    public Number findWithIndex(Number[] arr, int idx) throws ArrayIndexOutOfBoundsException{
        if((idx >= 0) && (idx < arr.length)){
            return arr[idx];
        }
        else {
            if(idx < 0) throw new ArrayIndexOutOfBoundsException("Index less than 0");
            else throw new ArrayIndexOutOfBoundsException("Index greater than array length");
        }
    }

    public void switcher(Object o) throws ClassCastException{
        if(o instanceof ExceptionThrower){
            o = (ExceptionThrower)this;
        }
        else{
            throw new ClassCastException(o.getClass().getName() + " is not an instance of ExceptionThrower");
        }
    }
}
