package dev.mohsenkohan.petclinic.bootstrap;

import dev.mohsenkohan.petclinic.model.*;
import dev.mohsenkohan.petclinic.services.owner.OwnerService;
import dev.mohsenkohan.petclinic.services.pet.PetService;
import dev.mohsenkohan.petclinic.services.pet.type.PetTypeService;
import dev.mohsenkohan.petclinic.services.specialty.SpecialtyService;
import dev.mohsenkohan.petclinic.services.vet.VetService;
import dev.mohsenkohan.petclinic.services.visit.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadDate();
            testQueryMethods();
        }
    }

    private void loadDate() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        // for map impl
        petService.save(mikesPet);

        Visit dogVisit = new Visit();
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Sneezy doggy");
        dogVisit.setPet(mikesPet);
        visitService.save(dogVisit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setType(savedCatPetType);

        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        // for map impl
        petService.save(fionasCat);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Specialty radiology = new Specialty();
        radiology.setName("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setName("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setName("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }

    private void testQueryMethods() {
        Owner owner = ownerService.findByLastName("Glenanne");
        System.out.println(owner.getFirstName());

        petService.findAllByOwner(owner).forEach(
                pet -> System.out.println(pet.getType().getName())
        );

        visitService.findAllByPet(petService.findById(1L)).forEach(
                visit -> System.out.println(visit.getDescription())
        );
    }
}
