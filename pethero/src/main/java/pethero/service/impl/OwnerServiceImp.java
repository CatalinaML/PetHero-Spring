package pethero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pethero.dao.OwnerDAO;
import pethero.domain.Owner;
import pethero.service.OwnerService;

import java.util.Optional;

@Service
public class OwnerServiceImp implements OwnerService {
    @Autowired
    private OwnerDAO ownerDAO;
    @Override
    @Transactional
    public void save(Owner owner){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passEncript = encoder.encode(owner.getPassword());
        owner.setPassword(passEncript);
        ownerDAO.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerDAO.delete(owner);
    }

    @Override
    public Optional<Owner> findById(int id) {
        return ownerDAO.findById(id);
    }

    @Override
    public void update(Owner owner) {

    }

    @Override
    public Owner findByUsername(String username) {
        return ownerDAO.findByUsername(username);
    }
}
