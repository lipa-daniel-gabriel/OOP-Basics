package Concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FestivalGate {
    List<TicketType> ticketTypeList = new LinkedList<>();


    /**
     * Method that ganerate a ticket and put it in a ticket list
     * @param ticketType
     */

    public synchronized void generateTicket(TicketType ticketType) {

        ticketTypeList.add(ticketType);
    }

    /**
     * Method that create a ticket queue, validate a ticket and if the ticket is validated it is placed in the queue
     * @param ticketType
     * @return
     */

    public synchronized Queue<TicketType> addTicketToQueue(TicketType ticketType) {

        Queue<TicketType> ticketTypeQueue = new LinkedList<>();
        ticketTypeValidation(ticketType, ticketTypeQueue);
        return ticketTypeQueue;
    }

    /**
     * Method that validate if the random ticket is an element of the TicketType enum
     * @param ticketType
     * @param ticketTypeQueue
     */

    public void ticketTypeValidation(TicketType ticketType, Queue<TicketType> ticketTypeQueue) {
        for (TicketType ticketType1 : ticketTypeList)
            if (ticketType1.equals(ticketType)) {
                ticketTypeQueue.add(ticketType);
            }
    }
}
