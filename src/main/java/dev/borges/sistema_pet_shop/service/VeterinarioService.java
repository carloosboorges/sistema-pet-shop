package dev.borges.sistema_pet_shop.service;
import dev.borges.sistema_pet_shop.dto.VeterinarioDTO;
import dev.borges.sistema_pet_shop.entity.VeterinarioModel;
import dev.borges.sistema_pet_shop.mapper.VeterinarioMapper;
import dev.borges.sistema_pet_shop.repository.PetRepository;
import dev.borges.sistema_pet_shop.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;
    private final VeterinarioMapper veterinarioMapper;
    private final PetRepository petRepository;


    public VeterinarioService(VeterinarioRepository veterinarioRepository, VeterinarioMapper veterinarioMapper, PetRepository petRepository) {
        this.veterinarioRepository = veterinarioRepository;
        this.veterinarioMapper = veterinarioMapper;
        this.petRepository = petRepository;
    }

    public VeterinarioDTO adicionarVeterinario(VeterinarioDTO veterinarioDTO){
        VeterinarioModel novoVeterinario = veterinarioMapper.toModel(veterinarioDTO);
        return veterinarioMapper.toDTO(veterinarioRepository.save(novoVeterinario));
    }

    public List<VeterinarioDTO> allVeterinario(){
        List<VeterinarioModel> listAll = veterinarioRepository.findAll();
        return listAll.stream()
                .map(veterinarioMapper::toDTO)
                .toList();
    }

    public Optional<VeterinarioDTO> listarPorId(Long id){
        Optional<VeterinarioModel> vetEncontrado = veterinarioRepository.findById(id);
        return vetEncontrado.map(veterinarioMapper::toDTO);
    }

    public VeterinarioDTO alterarVet(Long id, VeterinarioDTO veterinarioDTO){
        Optional<VeterinarioModel> vetEncontrado = veterinarioRepository.findById(id);
        if(vetEncontrado.isPresent()){
            VeterinarioModel vetAtualizado = veterinarioMapper.toModel(veterinarioDTO);
            vetAtualizado.setId(vetEncontrado.get().getId());
            return veterinarioMapper.toDTO(veterinarioRepository.save(vetAtualizado));
        }
        return null;
    }

    public String deletarVeterinario(Long id){
        veterinarioRepository.deleteById(id);
        return "Veterinario deletado com sucesso.";
    }
}
