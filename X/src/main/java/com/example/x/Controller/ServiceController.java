package com.example.x.Controller;

import com.example.x.Model.Service;
import com.example.x.Model.Stylist;
import com.example.x.Service.ServiceService;
import com.example.x.Service.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private StylistService stylistService;

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public String showServices(Model model) {
        List<Service> services = serviceService.getAllServices();
        model.addAttribute("services", services);
        return "services";
    }

    @GetMapping("/services/{serviceId}/stylists")
    public String showStylistsForService(@PathVariable Long serviceId, Model model) {
        Service service = serviceService.getServiceById(serviceId);
        List<Stylist> stylists = stylistService.getStylistsByService(service);
        model.addAttribute("stylists", stylists);
        return "stylists";
    }
}
