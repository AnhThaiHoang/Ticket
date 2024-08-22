package cz.local.Ticket.service;



import cz.local.Ticket.entities.TicketEntity;
import cz.local.Ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    public List<TicketEntity> getAll(){
        return ticketRepository.findAll();
    }

    public TicketEntity addTicket(TicketEntity ticketEntity){
        return ticketRepository.save(ticketEntity);
    }

    public TicketEntity editTicket(TicketEntity ticketEntity){
        TicketEntity edited = ticketRepository.getReferenceById(ticketEntity.getId());
        edited.setId(ticketEntity.getId());
        edited.setDescription(ticketEntity.getDescription());
        edited.setComment(ticketEntity.getComment());
        edited.setActualTimeInMinutes(ticketEntity.getActualTimeInMinutes());
        edited.setPriority(ticketEntity.getPriority());
        edited.setStatus(ticketEntity.getStatus());
        edited.setSummary(ticketEntity.getSummary());
        edited.setEstimateTimeInMinutes(ticketEntity.getEstimateTimeInMinutes());
        edited.setDueDate(ticketEntity.getDueDate());

        return ticketRepository.saveAndFlush(edited);
    }

    public void removeTicket(Long id){
        ticketRepository.delete(ticketRepository.getReferenceById(id));
    }

}
