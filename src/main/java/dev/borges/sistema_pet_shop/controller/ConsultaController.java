package dev.borges.sistema_pet_shop.controller;

import dev.borges.sistema_pet_shop.dto.ConsultaDTO;
import dev.borges.sistema_pet_shop.service.ConsultaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;


    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/adicionar")
    public ConsultaDTO adicionarConsulta(@RequestBody ConsultaDTO consultaDTO){
        return consultaService.criarConsulta(consultaDTO);
    }

    @GetMapping()
    public List<ConsultaDTO> listAll (){
        return consultaService.listarConsultas();
    }

    @GetMapping("/{id}")
    public ConsultaDTO listarPorId(@PathVariable Long id){
        return consultaService.listarPorId(id);
    }

    @PutMapping("/atualizar")
    public ConsultaDTO atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaDTO consultaDTO){
        return consultaService.atualizarConsulta(id, consultaDTO);
    }

    @DeleteMapping("/{id}")
    public void deletarConsulta(@PathVariable Long id){
        consultaService.listarPorId(id);
    }
}
