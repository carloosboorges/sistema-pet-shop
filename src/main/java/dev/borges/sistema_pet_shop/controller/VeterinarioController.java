package dev.borges.sistema_pet_shop.controller;
import dev.borges.sistema_pet_shop.dto.VeterinarioDTO;
import dev.borges.sistema_pet_shop.service.VeterinarioService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    public VeterinarioDTO adicionarVet(@RequestBody VeterinarioDTO veterinarioDTO){
        return veterinarioService.adicionarVeterinario(veterinarioDTO);
    }

    public List<VeterinarioDTO> listarAll(){
        return veterinarioService.allVeterinario();
    }

    public Optional<VeterinarioDTO> listarPorId(@PathVariable Long id){
        return veterinarioService.listarPorId(id);
    }

    public VeterinarioDTO atualizarVet(@PathVariable Long id, @RequestBody VeterinarioDTO veterinarioDTO){
        return veterinarioService.alterarVet(id, veterinarioDTO);
    }

    public void deletarVet(@PathVariable Long id){
        veterinarioService.deletarVeterinario(id);
    }

}
