package dev.borges.sistema_pet_shop.mapper;
import dev.borges.sistema_pet_shop.dto.ConsultaDTO;
import dev.borges.sistema_pet_shop.entity.ConsultaModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    ConsultaModel toModel(ConsultaDTO consultaDTO);

    ConsultaDTO toDTO(ConsultaModel consultaModel);
}
