package pethero.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pethero.domain.User;

import java.util.List;

public interface UserService {

    public void save(User user);
    public void delete(User user);
    public User findById(int id);
    public User findByUsername(String username);
    public void update(User user);
}
