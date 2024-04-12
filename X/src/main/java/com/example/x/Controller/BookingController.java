package com.example.x.Controller;

import com.example.x.Model.Client;
import com.example.x.Model.Stylist;
import com.example.x.Repository.ClientRepository;
import com.example.x.Repository.StylistRepository;
import com.example.x.Service.AppointmentService;
<<<<<<< HEAD
=======
import jakarta.servlet.http.HttpSession;
>>>>>>> 8b622ee (Second commit)
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
<<<<<<< HEAD
=======

>>>>>>> 8b622ee (Second commit)
    @Autowired
    private StylistRepository stylistRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/book-appointment")
<<<<<<< HEAD
    public String bookAppointment(@RequestParam Long stylistId, @RequestParam Long clientId, @RequestParam String dateTimeString, Model model) {
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);

        Stylist stylist = stylistRepository.findById(stylistId).orElse(null);
=======
    public String bookAppointment(@RequestParam Long stylistId, HttpSession session, @RequestParam String dateTimeString, Model model) {
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);

        Stylist stylist = stylistRepository.findById(stylistId).orElse(null);

        // Отримання clientId з сесії
        Long clientId = (Long) session.getAttribute("clientId");
>>>>>>> 8b622ee (Second commit)
        Client client = clientRepository.findById(clientId).orElse(null);

        if (stylist != null && client != null && appointmentService.isAppointmentAvailable(stylist, dateTime)) {
            appointmentService.bookAppointment(stylist, client, dateTime);
            return "redirect:/confirmation";
        } else {
            return "redirect:/services";
        }
    }

    @GetMapping("/confirmation")
    public String showConfirmation() {
        return "confirmation";
    }
}
