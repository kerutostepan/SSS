package com.example.x.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "services")
    private List<Stylist> stylists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Stylist> getStylists() {
        return stylists;
    }

    public void setStylists(List<Stylist> stylists) {
        this.stylists = stylists;
    }
}
