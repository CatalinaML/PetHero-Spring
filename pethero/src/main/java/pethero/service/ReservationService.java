package pethero.service;

import pethero.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    public void save(Reservation reservation);
    public List<Reservation> findByIdOwner(int id);
    public void delete(Reservation reservation);
    public Optional<Reservation> findById(long id);
    public List<Reservation> findByIdKeeper(int id);
    public void update(Reservation reservation);

}
