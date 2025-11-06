package dev.borges.sistema_pet_shop.service;
import dev.borges.sistema_pet_shop.dto.ClienteDTO;
import dev.borges.sistema_pet_shop.entity.ClienteModel;
import dev.borges.sistema_pet_shop.mapper.ClienteMapper;
import dev.borges.sistema_pet_shop.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteMapper clienteMapper, ClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO adicionarCliente(ClienteDTO clienteDTO){
        ClienteModel clienteNovo = clienteMapper.toModel(clienteDTO);
        return clienteMapper.toDTO(clienteRepository.save(clienteNovo));
    }

    public List<ClienteDTO> listarClientes(){
        List<ClienteModel> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::toDTO)
                .toList();
    }

    public ClienteDTO listarPorId(Long id){
        Optional<ClienteModel> clienteEncontrado = clienteRepository.findById(id);
        return clienteEncontrado.map(clienteMapper::toDTO).orElse(null);
    }

    public ClienteDTO altualizarCliente(Long id, ClienteDTO clienteDTO){
        Optional<ClienteModel> clienteEncontrado = clienteRepository.findById(id);
        if(clienteEncontrado.isPresent()){
            ClienteModel clienteAtualizado = clienteMapper.toModel(clienteDTO);
            clienteAtualizado.setId(id);
            return clienteMapper.toDTO(clienteRepository.save(clienteAtualizado));
        }
        return null;
    }

    public String deletarCliente(Long id){
        clienteRepository.deleteById(id);
        return "Cliente deletado com sucesso.";
    }
}
