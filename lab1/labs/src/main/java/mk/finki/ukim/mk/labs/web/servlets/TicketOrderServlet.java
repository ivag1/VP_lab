package mk.finki.ukim.mk.labs.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.labs.service.TicketOrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="ticket-order-servlet",urlPatterns = "/ticketOrder")
public class TicketOrderServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final TicketOrderService ticketOrderService;
    public TicketOrderServlet(SpringTemplateEngine springTemplateEngine,TicketOrderService ticketOrderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.ticketOrderService=ticketOrderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        String movieTitle=req.getParameter("movie");
        int numTickets= Integer.parseInt(req.getParameter("numTickets")); // mu davame string so ova req... zatoa go parsirame vo int
        String clientName=req.getParameter("clientName");
        String clientAddress=req.getRemoteAddr();

        webContext.setVariable("title", movieTitle); // ova movie go zima parametarot od input -> name='movie' od radio button-ot
        webContext.setVariable("tickets", numTickets);
        webContext.setVariable("clientName", clientName);
        webContext.setVariable("clientAddress", clientAddress);

        springTemplateEngine.process("orderConfirmation.html", webContext, resp.getWriter());


        this.ticketOrderService.placeOrder(movieTitle,clientName,clientAddress,numTickets);

    }
}