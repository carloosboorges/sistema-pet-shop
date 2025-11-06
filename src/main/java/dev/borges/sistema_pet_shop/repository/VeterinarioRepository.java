package dev.borges.sistema_pet_shop.repository;
import dev.borges.sistema_pet_shop.entity.VeterinarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository <VeterinarioModel, Long> {
}
