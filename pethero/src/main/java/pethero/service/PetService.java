package pethero.service;

import pethero.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    public Pet save(Pet pet);
    public void delete(Pet pet);
    public Optional<Pet> findById(int id);
    public void update(Pet pet);
    public List<Pet> findByIdUser(int id);
}

