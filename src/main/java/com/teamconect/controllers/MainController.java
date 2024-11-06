package com.teamconect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String redirectToLogin() {
        return "redirect:/login"; // Redirige a login.html cuando no está autenticado
    }

    @GetMapping("/home")
    public String home() {
        return "home";  // Carga la vista principal después de autenticarse
    }
}
