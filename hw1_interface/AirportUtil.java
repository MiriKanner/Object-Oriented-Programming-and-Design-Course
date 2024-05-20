import java.util.ArrayList;
import java.util.Arrays;
public class AirportUtil {
    public static void sortTransport(Comparable[] transport){
        Arrays.sort(transport);
    }

    static String reportAll (Movable[] movables) {
        ArrayList<String> buffer = new ArrayList<>();

        for (Movable m: movables) {
            if (m.getType() == "Train") {
                buffer.add("Train " + m.getId()+" " + "going from "+m.getSource()+" to "+m.getDestination()+". Currently in "+m.getCurrentLocation());
            } else {
                buffer.add("Plane " + m.getId()+" " + "going from "+m.getSource()+" to "+m.getDestination()+". Currently in "+m.getCurrentLocation());
            }

        }
        return String.join("\n",buffer);
    }
}
