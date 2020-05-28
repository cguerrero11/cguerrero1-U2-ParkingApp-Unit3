public class LostTicket implements Ticket {

    private int vehicleId;
    public LostTicket(Ticket ticket) {
        vehicleId = ticket.vehicleId();
    }

    @Override
    public int vehicleId() {
        return vehicleId;
    }

    @Override
    public int getCost() {
        return 25;
    }


}
