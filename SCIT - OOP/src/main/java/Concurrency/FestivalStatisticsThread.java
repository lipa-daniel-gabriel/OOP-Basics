package Concurrency;

public class FestivalStatisticsThread implements Runnable {
    private FestivalGate festivalGate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.festivalGate = gate;

    }

    /**
     * Method that show us the number of tickets validated from a specific gate and the exact number of each type of ticket
     */
    @Override
    public void run() {
        System.out.println(festivalGate.ticketTypeList.size() + " people entered");
        System.out.println(festivalGate.addTicketToQueue(TicketType.full).size() + " people have full tickets");
        System.out.println(festivalGate.addTicketToQueue(TicketType.fullVip).size() + " have free passes");
        System.out.println(festivalGate.addTicketToQueue(TicketType.freePass).size() + " have full VIP passes");
        System.out.println(festivalGate.addTicketToQueue(TicketType.oneDay).size() + " have one-day passes");
        System.out.println(festivalGate.addTicketToQueue(TicketType.oneDayVip).size() + " have one-day VIP passes");
        System.out.println("");

    }
}
