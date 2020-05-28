import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    public String input;
    public boolean close = false;
    Scanner key = new Scanner(System.in);
    TicketWriter tw = new TicketWriter();

    public UserInterface() throws IOException {

    }


    public boolean DisplayIn(){
        System.out.println("Best Value Parking Garage");
        System.out.println("==========================");
        System.out.println("1 - Check/In");
        System.out.println("3 - Close Garage");
        System.out.print("=>");
        input = key.nextLine();
        if(input.compareTo("1") == 0){
            try {
                tw.writeFile();
                System.out.println("Successfully checked in.");
            } catch (Exception e){
                System.out.println("The following error has occured: " + e);
            }

        } else if(input.compareTo("3") == 0){
            close = true;

        }
        return close;
    }

    TicketReader tr = new TicketReader();
    public void DisplayOut(){
        System.out.println("Best Value Parking Garage");
        System.out.println("==========================");
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.print("=>");
        input = key.nextLine();
        if(input.compareTo("1") == 0) {
            try {
                System.out.println("Receipt for a vehicle id " + tr.getvehicleId());
                System.out.println("\n\n");
                tr.displayTime();
                System.out.println("$" + tr.getCost());
            } catch (Exception e) {
                System.out.println("The following error has occurred: " + e);
            }
        } else if(input.compareTo("2") == 0){
            System.out.println("Receipt for a vehicle id " + tr.getvehicleId());
            System.out.println("\n\n");
            System.out.println("Lost Ticket");
            System.out.println("$25.00");

        }
    }
    public void closeGarage() throws IOException {
        tr.getTotal();
    }

}
