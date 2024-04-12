package com.example.x.Controller;

import com.example.x.Model.Client;
import com.example.x.Model.Stylist;
import com.example.x.Repository.ClientRepository;
import com.example.x.Repository.StylistRepository;
import com.example.x.Service.AppointmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class BookingController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private StylistRepository stylistRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/book-appointment")
    public String bookAppointment(@RequestParam Long stylistId, HttpSession session, @RequestParam String dateTimeString, Model model) {
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);

        Stylist stylist = stylistRepository.findById(stylistId).orElse(null);

        // Отримання clientId з сесії
        Long clientId = (Long) session.getAttribute("clientId");
        Client client = clientRepository.findById(clientId).orElse(null);

        if (stylist != null && client != null) {
            if (appointmentService.isAppointmentAvailable(stylist, dateTime) && appointmentService.canClientBookAppointment(clientId, dateTime)) {
                appointmentService.bookAppointment(stylist, client, dateTime);
                return "redirect:/confirmation";
            }
        }
        return "redirect:/services";
    }

    @GetMapping("/confirmation")
    public String showConfirmation() {
        return "confirmation";
    }
}
