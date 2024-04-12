package com.example.x.Controller;

import com.example.x.Model.Client;
import com.example.x.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("client", new Client());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("client") Client client, Model model) {
        Client existingClient = clientRepository.findByUsername(client.getUsername());
        if (existingClient != null) {
            model.addAttribute("error", "Username already exists. Please choose a different username.");
            return "register";
        }

        clientRepository.save(client);
        return "redirect:/login?registered";
    }
}
