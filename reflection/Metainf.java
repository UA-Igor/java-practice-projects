import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Metainf {

    private final String message = "You're hacked. Send 10 btc to 34kNXokGAdmLvsJFFZdrkn27PPtvYLXDYS";

    public String restoreClassMetainf(Class clazz){
        String metainf ="Class " + clazz.getName() + "\n\n";
        Field[] fields= clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        metainf += "Fields: " + '\n';
        for(Field f: fields){
            metainf += f.toString() + '\n';
        }

        metainf += '\n' + "Methods: " + '\n';
        for(Method m: methods){
            metainf += m.toString() + '\n';
        }
        return metainf;
    }

    public <T> void hackTheObject(T obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f: fields){
            if(f.getType().getName().equals("java.lang.String")) {
                f.setAccessible(true);
                f.set(obj, message);
            }
        }
    }
}
