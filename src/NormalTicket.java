import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NormalTicket implements Ticket {
    int vehicleId;
    private int TimeIn;
    private int TimeOut;

    public NormalTicket(){
            double rand = Math.random() * 5;
            //7am - 12pm
            TimeIn = (int) Math.ceil(rand);
            rand = Math.random() * 11;
            //1pm - 11pm
            TimeOut = (int) Math.ceil(rand);
            vehicleId = (int) (Math.random() * 200) + 100;
        }


    @Override
    public int vehicleId() {
        return vehicleId;
    }

    @Override
    public int getCost() throws ParseException {
        long diffHours;
        int timein = TimeIn + 6;
        String dateStop;
        String dateStart;
        if (timein > 9) {
            dateStart = "01/01/2012 " + timein + ":00:00";
        } else {
            dateStart = "01/01/2012 " + timein + "0:00:00";
        }
        if (TimeOut > 9) {
            dateStop = "01/01/2012 " + TimeOut + ":00:00";
        } else {
            dateStop = "01/01/2012 " + TimeOut + "0:00:00";
        }
        SimpleDateFormat format = null;
        Date time1 = format.parse(dateStart);
        Date time2 = format.parse(dateStop);
        long diff = time2.getTime() - time1.getTime();

        diffHours = diff / (60 * 60 * 1000) % 24;
        return (int)diffHours;
    }
}
