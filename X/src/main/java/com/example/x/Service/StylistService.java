package com.example.x.Service;

import com.example.x.Model.Stylist;
import com.example.x.Repository.StylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StylistService {

    @Autowired
    private StylistRepository stylistRepository;

    public List<Stylist> getAllStylists() {
        return stylistRepository.findAll();
    }

    public Stylist getStylistById(Long id) {
        return stylistRepository.findById(id).orElse(null);
    }

    public List<Stylist> getStylistsByService(com.example.x.Model.Service service) {
        return stylistRepository.findByServices(service);
    }

}
