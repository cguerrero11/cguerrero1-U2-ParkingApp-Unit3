public class TicketFactory {
    Ticket ticket;

    void generateNormalTicket(){
        ticket = new NormalTicket();
    }
    void generateLostTicket(){
        ticket = new LostTicket(new NormalTicket());
    }
}
