package dev.borges.sistema_pet_shop.service;
import dev.borges.sistema_pet_shop.dto.PetDTO;
import dev.borges.sistema_pet_shop.entity.PetModel;
import dev.borges.sistema_pet_shop.mapper.PetMapper;
import dev.borges.sistema_pet_shop.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final PetMapper petMapper;
    private final PetRepository petRepository;

    public PetService(PetMapper petMapper, PetRepository petRepository) {
        this.petMapper = petMapper;
        this.petRepository = petRepository;
    }

    public PetDTO adicionarPet(PetDTO petDTO){
        PetModel novoPet = petMapper.toModel(petDTO);
        return petMapper.toDTO(petRepository.save(novoPet));
    }
}
