package dev.borges.sistema_pet_shop.service;
import dev.borges.sistema_pet_shop.dto.PetDTO;
import dev.borges.sistema_pet_shop.entity.PetModel;
import dev.borges.sistema_pet_shop.mapper.PetMapper;
import dev.borges.sistema_pet_shop.repository.PetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public List<PetDTO> listarPets(){
        List<PetModel> allPets = petRepository.findAll();
        return allPets.stream()
                .map(petMapper::toDTO)
                .toList();
    }

    public Optional<PetDTO> petPorId(Long id){
        Optional<PetModel> petEncontrado = petRepository.findById(id);
        return petEncontrado.map(petMapper::toDTO);
    }

    public PetDTO alterarPet(Long id, PetDTO petDTO){
        Optional<PetModel> petEncontrado = petRepository.findById(id);
        if(petEncontrado.isPresent()){
            PetModel petAtualizado = petMapper.toModel(petDTO);
            petAtualizado.setId(petEncontrado.get().getId());
            return petMapper.toDTO(petRepository.save(petAtualizado));
        }
        return null;
    }

    public String deletarPet(Long id){
        petRepository.deleteById(id);
        return "Pet deletado com sucesso.";
    }
}
