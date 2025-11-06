package dev.borges.sistema_pet_shop.repository;
import dev.borges.sistema_pet_shop.entity.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<ConsultaModel, Long> {
}
