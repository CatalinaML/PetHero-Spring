package pethero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pethero.dao.KeeperDAO;
import pethero.domain.Keeper;
import pethero.service.KeeperService;

import java.util.List;
import java.util.Optional;

@Service
public class KeeperServiceImp implements KeeperService {
    @Autowired
    private KeeperDAO keeperDAO;
    @Override
    @Transactional(readOnly = true)
    public List<Keeper> findAll() {
        return keeperDAO.findAll();
    }

    @Override
    public void save(Keeper keeper) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passEncript = encoder.encode(keeper.getPassword());
        keeper.setPassword(passEncript);
        keeperDAO.save(keeper);
    }

    @Override
    public void delete(Keeper keeper) {
        keeperDAO.delete(keeper);
    }

    @Override
    public Optional<Keeper> findById(int id) {
        return keeperDAO.findById(id);
    }

    @Override
    public void update(Keeper keeper) {

    }
}
