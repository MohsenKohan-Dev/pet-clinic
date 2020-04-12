package dev.mohsenkohan.petclinic.controllers;

import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.model.Visit;
import dev.mohsenkohan.petclinic.services.pet.PetService;
import dev.mohsenkohan.petclinic.services.visit.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/owners/{ownerId}/pets/{petId}/visits")
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @ModelAttribute(name = "pet")
    public Pet findPet(@PathVariable Long petId) {
        return petService.findById(petId);
    }

    @GetMapping("/new")
    public String initNewVisitForm(Model model) {
        model.addAttribute("visit", new Visit());
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/new")
    public String processNewVisitForm(@ModelAttribute Pet pet, @Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            pet.addVisit(visit);
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
