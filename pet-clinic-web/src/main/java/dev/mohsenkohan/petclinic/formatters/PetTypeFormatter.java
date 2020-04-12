package dev.mohsenkohan.petclinic.formatters;

import dev.mohsenkohan.petclinic.model.PetType;
import dev.mohsenkohan.petclinic.services.pet.type.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService typeService;

    public PetTypeFormatter(PetTypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> petTypes = typeService.findAll();

        for (PetType type : petTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}
