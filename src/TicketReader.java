import java.io.*;
import java.io.InputStream;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;

public class TicketReader {
    private File filepath = new File("ptickets.csv");
    private int vehicleId;
    private int TimeIn;
    private int TimeOut;
    ArrayList pInfo;
    private BufferedReader reader = null;




    public TicketReader() throws IOException {
        //set variables
        String line;
        String lastline = "";
        try {

            reader = new BufferedReader(new FileReader(filepath));

            while ((line = reader.readLine()) != null) {
                lastline = line;
            }
            pInfo = new ArrayList<>(Arrays.asList(lastline.split(",")));
            this.vehicleId = (int) pInfo.get(0);
            this.TimeIn = (int) pInfo.get(1);
            this.TimeOut = (int) pInfo.get(2);

        } catch(Exception e){
            System.out.println("The following error has occured: " + e);
        } finally {
            reader.close();
        }

    }

    public int getvehicleId(){

        return this.vehicleId;
    }

    long diffHours;
    public void displayTime() throws ParseException {
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

        //HH converts hour in 24 hours format (0-23), day calculation
        format = new SimpleDateFormat("HH");


        if (timein > 11) {
            System.out.println(diffHours + " hours parked  " + timein + "pm - " + TimeOut + "pm");
        } else {
            System.out.println(diffHours + " hours parked  " + timein + "am - " + TimeOut + "pm");
        }
    }

    public double getCost(){
        double cost = 5;
        if(diffHours < 3){
            cost += diffHours - 3;
        } else if(diffHours >= 24){
            cost = 15;
        }

        return cost;

    }
    public void getTotal() throws IOException {
        String line = null;
        double total = 0;
        System.out.println("Garage has been closed.\n\n");
        pInfo = new ArrayList<>(Arrays.asList(line.split(",")));
        while ((line = reader.readLine()) != null) {



        }
        System.out.println(getCost() + " was collected overall.");

    }

}
