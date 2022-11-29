public class MyClass {
    private String name;
    private long id;
    private String message;

    public MyClass(String name, long id) {
        this.name = name;
        this.id = id;
        this.message = " ";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString(){
        return "User: " + name + " with ID: " + id + " sends somewhere: " + message;
    }
}
