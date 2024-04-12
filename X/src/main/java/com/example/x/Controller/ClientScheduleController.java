package com.example.x.Controller;

import com.example.x.Model.Appointment;
import com.example.x.Repository.AppointmentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientScheduleController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/client/schedule")
    public String viewClientSchedule(HttpSession session, Model model) {
        Long clientId = (Long) session.getAttribute("clientId");
        if (clientId != null) {
            List<Appointment> clientAppointments = appointmentRepository.findByClientId(clientId);
            model.addAttribute("clientAppointments", clientAppointments);
            return "client_schedule";
        } else {
            return "redirect:/login"; // Перенаправлення на сторінку логіну, якщо клієнт не увійшов
        }
    }

    @PostMapping("/client/schedule/cancel/{id}")
    public String cancelAppointment(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
        return "redirect:/client/schedule"; // Повернення на сторінку розкладу після відміни запису
    }
}
