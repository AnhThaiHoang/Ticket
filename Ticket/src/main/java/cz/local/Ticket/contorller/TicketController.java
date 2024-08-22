package cz.local.Ticket.contorller;

import cz.local.Ticket.entities.TicketEntity;
import cz.local.Ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public List<TicketEntity> getAll(){
        return ticketService.getAll();
    }

    @PostMapping("/ticket")
    public TicketEntity addTicket(@RequestBody TicketEntity entity){
        return ticketService.addTicket(entity);
    }

    @PutMapping("/ticket")
    public TicketEntity editTicket(@RequestBody TicketEntity entity){
        return ticketService.editTicket(entity);
    }

    @DeleteMapping("/ticket")
    public void deleteTicket(@RequestBody Long id){
        ticketService.removeTicket(id);
    }
}
