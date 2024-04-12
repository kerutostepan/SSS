package com.example.x.Controller;

import com.example.x.Model.Service;
import com.example.x.Model.Stylist;
import com.example.x.Repository.ServiceRepository;
import com.example.x.Repository.StylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private StylistRepository stylistRepository;

    @GetMapping("/services")
    public String showServices(Model model) {
        List<Service> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        return "services";
    }

    @GetMapping("/services/{serviceId}/stylists")
    public String showStylistsForService(@PathVariable Long serviceId, Model model) {
        List<Stylist> stylists = stylistRepository.findAll(); // Замість findAll() можна використовувати власний метод для фільтрації
        model.addAttribute("stylists", stylists);
        return "stylists";
    }
}
