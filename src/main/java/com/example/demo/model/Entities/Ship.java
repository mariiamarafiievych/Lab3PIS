package com.example.demo.model.Entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Entity
@Builder
@Table(name = "ships")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipId;
    private int capability;
    private String route;
    private int ports;
    private float duration;


}
