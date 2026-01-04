package com.squach.out_of_the_chat.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Trips")
public class Trip {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;
}
