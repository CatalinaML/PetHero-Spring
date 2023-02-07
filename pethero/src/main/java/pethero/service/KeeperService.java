package pethero.service;

import pethero.domain.Keeper;
import java.util.List;

public interface KeeperService {

    public List<Keeper> findAll();
    public void save(Keeper keeper);
    public void delete(Keeper keeper);
    public Keeper findById(int id);
    public void update(Keeper keeper);
}
