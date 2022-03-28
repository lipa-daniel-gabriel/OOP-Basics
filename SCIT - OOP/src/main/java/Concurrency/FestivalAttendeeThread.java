package Concurrency;

public class FestivalAttendeeThread implements Runnable {
    private TicketType ticketType;
    private FestivalGate festivalGate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.festivalGate = gate;

    }

    @Override
    public void run() {
        festivalGate.generateTicket(ticketType);
    }
}
