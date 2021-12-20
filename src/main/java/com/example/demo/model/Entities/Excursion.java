package com.example.demo.model.Entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "excursions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer excursionId;
    private String excursionName;
}
