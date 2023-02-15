package pethero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pethero.dao.PetDAO;
import pethero.domain.Pet;
import pethero.service.PetService;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImp implements PetService {

    @Autowired
    private PetDAO petDAO;
    @Override
    @Transactional
    public Pet save(Pet pet) {
        return petDAO.save(pet);
    }

    @Override
    @Transactional
    public void delete(Pet pet) {
        petDAO.delete(pet);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pet> findById(int id) {
        return petDAO.findByIdPet(id); //hay que hacer la sentencia sql
    }

    @Override
    public void update(Pet pet) {
        //hay que hacer la sentencia sql
    }

    @Override
    public List<Pet> findByIdUser(int id) {
        return petDAO.findByIdOwner(id);
    }

    @Override
    public List<Pet> findBySize(int id, String size) {
        return petDAO.findBySize(id, size);
    }
}
