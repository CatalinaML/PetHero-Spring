package pethero.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pethero.domain.Keeper;

public interface KeeperDAO extends JpaRepository<Keeper, Integer> {
}
