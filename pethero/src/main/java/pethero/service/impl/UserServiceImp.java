package pethero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pethero.dao.UserDAO;
import pethero.domain.User;
import pethero.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Service("userDetailsService")
public class UserServiceImp implements UserService, UserDetailsService {
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
        return userDAO.findByUsername(username);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        List<GrantedAuthority> rol = new ArrayList<GrantedAuthority>();

        rol.add(new SimpleGrantedAuthority(user.getType()));

        System.out.println(new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),rol));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),rol);
    }
}
