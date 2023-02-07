package pethero.service;

import pethero.domain.Owner;

public interface OwnerService {

    public void save(Owner owner);
    public void delete(Owner owner);
    public Owner findById(int id);
    public void update(Owner owner);
}
