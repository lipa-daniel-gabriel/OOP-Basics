package Concurrency;

public class main {
    public static void main(String[] args) throws InterruptedException {

        FestivalGate gate = new FestivalGate();
        infiniteLoopMethod(gate);
    }

    /**
     * Method that start an infinite loop
     * @param gate
     * @throws InterruptedException
     */

    private static void infiniteLoopMethod(FestivalGate gate) throws InterruptedException {
        while (true) {
            TicketType ticketType = TicketType.randomTicket();
            FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
            FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
            statsThreadThreadStart(festivalAttendee);
            festivalAttendeethreadStart(statsThread);
        }
    }

    /**
     * Method that start and join the Thread
     * @param festivalAttendee
     * @throws InterruptedException
     */

    private static void statsThreadThreadStart(FestivalAttendeeThread festivalAttendee) throws InterruptedException {
        Thread thread = new Thread(festivalAttendee);
        thread.start();
        thread.join();
    }

    /**
     * Method that start the Thread
     * @param festivalAttendee
     * @throws InterruptedException
     */
    private static void festivalAttendeethreadStart(FestivalStatisticsThread festivalAttendee) throws InterruptedException {
        Thread thread = new Thread(festivalAttendee);
        thread.start();
        thread.sleep(5000);

    }
}


