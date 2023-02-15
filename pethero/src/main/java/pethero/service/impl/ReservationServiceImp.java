package pethero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pethero.dao.ReservationDAO;
import pethero.domain.Reservation;
import pethero.service.ReservationService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp implements ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    @Transactional
    public void save(Reservation reservation) {
        reservationDAO.save(reservation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findByIdUser(int id) {
        return reservationDAO.findByIdUser(id);
    }

    @Override
    @Transactional
    public void delete(Reservation reservation) {
        reservationDAO.delete(reservation);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reservation> findById(long id) {
        return reservationDAO.findById(id);
    }

    @Override
    @Transactional
    public void update(Reservation reservation) {
        
    }
}
