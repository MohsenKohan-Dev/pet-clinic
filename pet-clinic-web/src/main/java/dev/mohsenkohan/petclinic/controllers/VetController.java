package dev.mohsenkohan.petclinic.controllers;

import dev.mohsenkohan.petclinic.model.Vet;
import dev.mohsenkohan.petclinic.services.vet.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

    @GetMapping("/api/vets")
    @ResponseBody
    public Set<Vet> showResourcesVetList() {
        return vetService.findAll();
    }
}
