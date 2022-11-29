/*
1. Реализовать рефлексивный метод, который восстанавливает по метаинформации исходный класс. Метод вида:
public String restoreClassMetainf(Class clazz) {...}
2. С помощью рефлексии написать метод, который достает по метаинформации
все строковые поля обьекта и устанавливает в них значения
"You're hacked. Send 10 btc to 34kNXokGAdmLvsJFFZdrkn27PPtvYLXDYS".
 Метод вида:
public void hackTheObject(Object obj) {...}

3. Покрыть тестами приложение - инернет-магазин
 */

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Metainf meta = new Metainf();
        System.out.println(meta.restoreClassMetainf(MyClass.class));
        MyClass my = new MyClass("John", 123765476457L);
        System.out.println(my);
        meta.hackTheObject(my);
        System.out.println(my);
    }
}