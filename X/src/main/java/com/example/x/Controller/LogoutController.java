package com.example.x.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Чистимо сесію для розлогінення клієнта
        session.invalidate();
        return "redirect:/login"; // Перенаправляємо на сторінку логіну після розлогінення
    }
}
