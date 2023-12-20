package mk.finki.ukim.mk.labs.service;

import mk.finki.ukim.mk.labs.model.TicketOrder;
import mk.finki.ukim.mk.labs.repository.TicketOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketOrderImplementation implements TicketOrderService{

private final TicketOrderRepository ticketOrderRepository;

public TicketOrderImplementation(TicketOrderRepository ticketOrderRepository){
    this.ticketOrderRepository = ticketOrderRepository;
}
    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, long numberOfTickets) {
        return new TicketOrder(movieTitle,clientName,address,numberOfTickets);
    }

    @Override
    public List<TicketOrder> getAllTickets() {
        return ticketOrderRepository.listAll();
    }

}
