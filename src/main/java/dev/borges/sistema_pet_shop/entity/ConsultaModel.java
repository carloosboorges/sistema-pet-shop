package dev.borges.sistema_pet_shop.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_consulta")
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataConsulta;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetModel pet;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private VeterinarioModel veterinario;
}
