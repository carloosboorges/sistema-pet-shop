package dev.borges.sistema_pet_shop.dto;
import lombok.Data;

@Data
public class PetDTO {
    private Long id;
    private String nome;
    private String tipo;
    private String raca;
    private Long clienteId; // referência ao dono do pet
}