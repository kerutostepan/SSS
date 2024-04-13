package com.example.x.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Stylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "stylist_service",
        joinColumns = @JoinColumn(name = "stylist_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;

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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
