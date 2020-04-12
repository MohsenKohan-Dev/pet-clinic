package dev.mohsenkohan.petclinic.controllers;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.model.PetType;
import dev.mohsenkohan.petclinic.services.owner.OwnerService;
import dev.mohsenkohan.petclinic.services.pet.PetService;
import dev.mohsenkohan.petclinic.services.pet.type.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService typeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService typeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.typeService = typeService;
    }

    @ModelAttribute(name = "types")
    public Collection<PetType> populatePetTypes() {
        return typeService.findAll();
    }

    @ModelAttribute(name = "owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(@ModelAttribute Owner owner, Model model) {
        Pet pet = new Pet();
        owner.addPet(pet);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(@ModelAttribute Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        owner.addPet(pet);

        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@ModelAttribute Owner owner, @Valid Pet pet,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            owner.addPet(pet);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }
}
