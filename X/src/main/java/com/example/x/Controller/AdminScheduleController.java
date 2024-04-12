package com.example.x.Controller;

import com.example.x.Model.Appointment;
import com.example.x.Repository.AppointmentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminScheduleController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/admin/schedule")
    public String viewSchedule(HttpSession session, Model model) {
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
        if (isAdmin != null && isAdmin) {
            List<Appointment> appointments = appointmentRepository.findAll(); // Отримати всі записи
            model.addAttribute("appointments", appointments);
            return "admin_schedule"; // Повернути шаблон для відображення розкладу
        } else {
            return "redirect:/login"; // Перенаправлення на сторінку логіну, якщо немає прав доступу
        }
    }
}
