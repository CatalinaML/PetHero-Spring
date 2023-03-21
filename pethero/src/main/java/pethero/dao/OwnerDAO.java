package pethero.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pethero.domain.Owner;

public interface OwnerDAO extends JpaRepository<Owner, Integer> {

    Owner findByUsername(String username);
}
