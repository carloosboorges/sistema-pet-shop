package dev.borges.sistema_pet_shop.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ConsultaDTO {

    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataConsulta;
    private String descricao;
    private Long petID;
    private Long veterinarioId;


}
