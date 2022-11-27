public abstract class Animal implements Eatable{
    private final String name;
    private final int walkingLegs; //2 legs or 4
    Animal(String name, int legs){
        this.name = name;
        this.walkingLegs = legs;
    }

    public abstract void move();

    public String getName() {
        return name;
    }

    public int getWalkingLegs() {
        return walkingLegs;
    }

    protected void finalize(){
        System.out.println("Finalize!");
    }
}
