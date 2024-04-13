package com.example.x.Service;

import com.example.x.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<com.example.x.Model.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public com.example.x.Model.Service getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

}
