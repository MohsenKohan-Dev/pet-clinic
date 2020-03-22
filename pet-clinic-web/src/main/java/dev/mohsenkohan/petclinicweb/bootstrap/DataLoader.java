package dev.mohsenkohan.petclinicweb.bootstrap;

import dev.mohsenkohan.petclinicdata.model.Owner;
import dev.mohsenkohan.petclinicdata.model.Vet;
import dev.mohsenkohan.petclinicdata.repositories.MapRepositoryImpl;
import dev.mohsenkohan.petclinicdata.services.owner.OwnerService;
import dev.mohsenkohan.petclinicdata.services.owner.OwnerServiceMapImpl;
import dev.mohsenkohan.petclinicdata.services.vet.VetService;
import dev.mohsenkohan.petclinicdata.services.vet.VetServiceMapImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMapImpl(new MapRepositoryImpl<>(new HashMap<>()));
        vetService = new VetServiceMapImpl(new MapRepositoryImpl<>(new HashMap<>()));
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet1);

        System.out.println("Loaded Vets....");
    }
}
