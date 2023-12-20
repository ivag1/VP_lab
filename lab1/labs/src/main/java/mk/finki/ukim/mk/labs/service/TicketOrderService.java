package mk.finki.ukim.mk.labs.service;

import mk.finki.ukim.mk.labs.model.TicketOrder;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TicketOrderService{
    TicketOrder placeOrder(String movieTitle, String clientName, String address, long numberOfTickets);
    List<TicketOrder> getAllTickets();
    //void deleteTicket(long id);
}
