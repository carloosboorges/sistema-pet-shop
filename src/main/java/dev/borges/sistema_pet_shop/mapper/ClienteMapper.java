package dev.borges.sistema_pet_shop.mapper;
import dev.borges.sistema_pet_shop.dto.ClienteDTO;
import dev.borges.sistema_pet_shop.entity.ClienteModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteModel toModel(ClienteDTO clienteDto);

    ClienteDTO toDTO (ClienteModel clienteModel);
}
