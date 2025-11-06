package dev.borges.sistema_pet_shop.dto;
import lombok.Data;


@Data
public class VeterinarioDTO {
    private Long id;
    private String nome;
    private String especialidade;
}