package pethero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pethero.dao.UserDAO;
import pethero.domain.User;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void update(User user) {

    }
}
