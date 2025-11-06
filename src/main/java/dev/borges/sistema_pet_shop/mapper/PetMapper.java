package dev.borges.sistema_pet_shop.mapper;
import dev.borges.sistema_pet_shop.dto.PetDTO;
import dev.borges.sistema_pet_shop.entity.PetModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetModel toModel(PetDTO petDTO);

    PetDTO toDTO(PetModel petModel);
}
