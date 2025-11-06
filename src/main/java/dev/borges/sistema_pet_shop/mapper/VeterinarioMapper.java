package dev.borges.sistema_pet_shop.mapper;
import dev.borges.sistema_pet_shop.dto.VeterinarioDTO;
import dev.borges.sistema_pet_shop.entity.VeterinarioModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeterinarioMapper {

    VeterinarioModel toModel(VeterinarioDTO veterinarioDTO);

    VeterinarioDTO toDTO(VeterinarioModel veterinarioModel);
}
