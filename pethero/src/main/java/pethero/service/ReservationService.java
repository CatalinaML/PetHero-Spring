package pethero.service;

import pethero.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    public void save(Reservation reservation);
    public List<Reservation> findByIdUser(int id);
    public void delete(Reservation reservation);
    public Optional<Reservation> findById(long id);
    public void update(Reservation reservation);

}
