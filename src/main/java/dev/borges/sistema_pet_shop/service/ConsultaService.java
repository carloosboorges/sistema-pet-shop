package dev.borges.sistema_pet_shop.service;

import dev.borges.sistema_pet_shop.dto.ConsultaDTO;
import dev.borges.sistema_pet_shop.entity.ConsultaModel;
import dev.borges.sistema_pet_shop.mapper.ConsultaMapper;
import dev.borges.sistema_pet_shop.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final ConsultaMapper consultaMapper;

    public ConsultaService(ConsultaRepository consultaRepository, ConsultaMapper consultaMapper) {
        this.consultaRepository = consultaRepository;
        this.consultaMapper = consultaMapper;
    }

    public ConsultaDTO criarConsulta(ConsultaDTO consultaDTO) {
        ConsultaModel novaConsulta = consultaMapper.toModel(consultaDTO);
        return consultaMapper.toDTO(consultaRepository.save(novaConsulta));

    }

    public List<ConsultaDTO> listarConsultas() {
        List<ConsultaModel> consulta = consultaRepository.findAll();
        return consulta.stream()
                .map(consultaMapper::toDTO)
                .toList();
    }

    public ConsultaDTO listarPorId(Long id) {
        Optional<ConsultaModel> listaEncontrada = consultaRepository.findById(id);
        return listaEncontrada.map(consultaMapper::toDTO).orElse(null);

    }

    public ConsultaDTO atualizarConsulta (Long id, ConsultaDTO consultaDTO){
        Optional<ConsultaModel> consultaExistente = consultaRepository.findById(id);
        if(consultaExistente.isPresent()){
            ConsultaModel consultaAtualizada = consultaMapper.toModel(consultaDTO);
            consultaAtualizada.setId(consultaExistente.get().getId());
            return consultaMapper.toDTO(consultaRepository.save(consultaAtualizada));
        }
        return null;
    }
}
