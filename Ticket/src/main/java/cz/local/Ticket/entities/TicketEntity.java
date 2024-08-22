package cz.local.Ticket.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import cz.local.Ticket.constant.Priorities;
import cz.local.Ticket.constant.Statuses;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity(name = "ticket")
@Getter
@Setter
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Priorities priority;

    @Enumerated(EnumType.STRING)
    private Statuses status;

    private String summary;

    private String description;

    private int estimateTimeInMinutes;

    private int actualTimeInMinutes;

    private String comment;


}
