package dev.borges.sistema_pet_shop.controller;
import dev.borges.sistema_pet_shop.dto.PetDTO;
import dev.borges.sistema_pet_shop.service.PetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/adicionar")
        public PetDTO adicionarPet(@RequestBody PetDTO petDTO){
        return petService.adicionarPet(petDTO);
    }

    @GetMapping()
    public List<PetDTO> listarAll(){
        return petService.listarPets();
    }

    @GetMapping("/{id}")
    public Optional<PetDTO> listarPetPorId(@PathVariable Long id){
        return petService.petPorId(id);
    }


}
