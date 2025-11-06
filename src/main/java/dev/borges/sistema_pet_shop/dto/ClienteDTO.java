package dev.borges.sistema_pet_shop.dto;
import lombok.Data;
import java.util.List;

@Data
public class ClienteDTO {
        private Long id;
        private String nome;
        private String telefone;
        private String email;
        private List<PetDTO> pets;


}
