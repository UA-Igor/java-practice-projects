import java.util.LinkedList;
import java.util.List;

public class SellingArea {
    private static List<Vehicle> vehiclesList = new LinkedList<>();

    public static void addVehicle(Vehicle v){
        vehiclesList.add(v);
    }

    public static boolean removeVehicle(Vehicle v){
        if (vehiclesList.contains(v)){
            vehiclesList.remove(v);
            return true;
        }
        else return false;
    }

    public static List<Vehicle> getVehiclesList(){
        return vehiclesList;
    }
}
