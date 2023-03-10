package pethero.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pethero.domain.Reservation;

import java.util.List;

public interface ReservationDAO extends JpaRepository<Reservation, Long> {

    List<Reservation> findByIdOwner(int id);
    List<Reservation> findByIdKeeper(int id);
}
