package dev.borges.sistema_pet_shop.repository;
import dev.borges.sistema_pet_shop.entity.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
