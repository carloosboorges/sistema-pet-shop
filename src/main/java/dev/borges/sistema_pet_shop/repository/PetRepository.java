package dev.borges.sistema_pet_shop.repository;
import dev.borges.sistema_pet_shop.entity.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetModel, Long> {
}
