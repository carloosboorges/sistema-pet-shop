package dev.borges.sistema_pet_shop.controller;

import dev.borges.sistema_pet_shop.dto.ClienteDTO;
import dev.borges.sistema_pet_shop.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/adicionar")
    public ClienteDTO adicionarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.adicionarCliente(clienteDTO);
    }

    @GetMapping()
    public List<ClienteDTO> listarAll() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO listarPorId(@PathVariable Long id) {
        return clienteService.listarPorId(id);
    }

    @PutMapping("/atualizar")
    public ClienteDTO atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.altualizarCliente(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

}
