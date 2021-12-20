package com.example.demo.model.Entities;
import com.example.demo.model.Entities.Ship;
import com.example.demo.model.Entities.Excursion;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    private String clientFullName;
    private String clientEmail;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Ship ship;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "excursion_id")
    private Excursion excursion;
    private String clientTicketClass;
    private String clientBonus;
}
