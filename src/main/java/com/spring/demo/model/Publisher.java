package com.spring.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;

    @OneToMany
    @JoinColumn(name ="publisher_id")
    private List<Book> books;
}
