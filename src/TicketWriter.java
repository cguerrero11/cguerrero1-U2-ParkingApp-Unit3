import java.io.*;

import java.time.LocalDateTime;


public class TicketWriter {
    private int vehicleId;
    private int timeIn;
    private int timeOut;
    String filepath = "ptickets.csv";
    Writer writer = null;



    public TicketWriter() throws IOException {
        double rand = Math.random() * 5;
        //7am - 12pm
        timeIn = (int) Math.ceil(rand);
        rand = Math.random() * 11;
        //1pm - 11pm
        timeOut = (int) Math.ceil(rand);
        vehicleId = (int) (Math.random() * 200) + 100;

        //System.out.println(Math.ceil(rand));
    }

    public void writeFile() throws IOException {
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath)));
        writer.write(vehicleId + "," + timeIn + "," + timeOut + "\n");
        writer.close();
    }

}
