package pethero.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pethero.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface PetDAO extends JpaRepository<Pet, Integer> {

    Optional<Pet> findByIdPet(int idPet);
    List<Pet> findByIdOwner(int id);

}
