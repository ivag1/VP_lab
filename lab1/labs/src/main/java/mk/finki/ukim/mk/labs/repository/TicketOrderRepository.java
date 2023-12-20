package mk.finki.ukim.mk.labs.repository;

import mk.finki.ukim.mk.labs.model.Movie;
import mk.finki.ukim.mk.labs.model.TicketOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketOrderRepository {
List<TicketOrder> ticketOrderList = new ArrayList<>();

public List<TicketOrder> listAll(){
    return ticketOrderList;
}

public TicketOrder placeOrder(String movieTitle, String clientName, String address, long numberOfTickets){
    TicketOrder ticketOrder = new TicketOrder(movieTitle,clientName,address,numberOfTickets);
    ticketOrderList.add(ticketOrder);
    return ticketOrder;
}
}
