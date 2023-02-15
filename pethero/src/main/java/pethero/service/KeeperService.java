package pethero.service;

import pethero.domain.Keeper;
import java.util.List;
import java.util.Optional;

public interface KeeperService {

    public List<Keeper> findAll();
    public void save(Keeper keeper);
    public void delete(Keeper keeper);
    public Optional<Keeper> findById(int id);
    public void update(Keeper keeper);
}
