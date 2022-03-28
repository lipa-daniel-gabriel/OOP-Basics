package Concurrency;

import java.util.Random;

enum TicketType {
    full,
    fullVip,
    freePass,
    oneDay,
    oneDayVip;

    /**
     * Method that generate and return a randomTicket
     * @return
     */
    public static TicketType randomTicket() {
        return TicketType.values()[new Random().nextInt(TicketType.values().length)];
    }
}








