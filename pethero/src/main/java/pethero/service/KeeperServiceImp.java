package pethero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pethero.dao.KeeperDAO;
import pethero.domain.Keeper;

import java.util.List;

@Service
public class KeeperServiceImp implements KeeperService{
    @Autowired
    private KeeperDAO keeperDAO;
    @Override
    @Transactional(readOnly = true)
    public List<Keeper> findAll() {
        return keeperDAO.findAll();
    }

    @Override
    public void save(Keeper keeper) {
        keeperDAO.save(keeper);
    }

    @Override
    public void delete(Keeper keeper) {
        keeperDAO.delete(keeper);
    }

    @Override
    public Keeper findById(int id) {
        return null;
    }

    @Override
    public void update(Keeper keeper) {

    }
}
