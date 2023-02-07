package pethero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pethero.dao.OwnerDAO;
import pethero.domain.Owner;

@Service
public class OwnerServiceImp implements OwnerService{
    @Autowired
    private OwnerDAO ownerDAO;
    @Override
    @Transactional
    public void save(Owner owner) {
        ownerDAO.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerDAO.delete(owner);
    }

    @Override
    public Owner findById(int id) {
        return null;
    }

    @Override
    public void update(Owner owner) {

    }
}
