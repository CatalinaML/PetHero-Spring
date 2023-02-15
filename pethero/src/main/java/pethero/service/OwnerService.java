package pethero.service;

import pethero.domain.Owner;

import java.util.Optional;

public interface OwnerService {

    public void save(Owner owner);
    public void delete(Owner owner);
    public Optional<Owner> findById(int id);
    public void update(Owner owner);
}
