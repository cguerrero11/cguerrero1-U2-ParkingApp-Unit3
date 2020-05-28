import java.text.ParseException;
import java.util.ArrayList;

interface Ticket {
     int vehicleId();
     int getCost() throws ParseException;
}
