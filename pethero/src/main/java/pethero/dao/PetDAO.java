package pethero.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pethero.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface PetDAO extends JpaRepository<Pet, Integer> {

    Optional<Pet> findByIdPet(int idPet);
    List<Pet> findByIdOwner(int id);

    @Query("SELECT p FROM Pet p WHERE p.idOwner = ?1 AND p.petSize = ?2")
    List<Pet> findBySize(int id, String size);

}
