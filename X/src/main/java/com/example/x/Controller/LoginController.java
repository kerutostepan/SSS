package com.example.x.Controller;


import com.example.x.Model.Client;
import com.example.x.Repository.ClientRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("client", new Client());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("client") Client client, HttpSession session, Model model) {
        Client existingClient = clientRepository.findByUsername(client.getUsername());

        if (existingClient != null && existingClient.getPassword().equals(client.getPassword())) {
            if (existingClient.isAdmin()) {
                session.setAttribute("isAdmin", true);
                return "redirect:/admin/schedule";
            } else {
                session.setAttribute("clientId", existingClient.getId());
                return "redirect:/services";
            }
        } else {
            model.addAttribute("error", "Invalid username or password. Please try again.");
            return "login";
        }
    }
}
