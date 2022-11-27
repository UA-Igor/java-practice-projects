public class Main {
    public static void main(String[] args){

        Guest anton = new Guest(300);
        Guest ann = new Guest(1500);

        anton.feed("Monkey");
        System.out.println(anton.getMoney());

        ann.feedAll();
        System.out.println(ann.getMoney());

        anton.feedAll();
        System.out.println("---------------------------------");
        System.out.println("Attempt to finalize");
        for(int i = 1_000_000; i > 0; --i){
            new Monkey();
        }
    }
}