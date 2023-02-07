package pethero.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pethero.domain.User;

public interface UserDAO extends JpaRepository<User, Integer> {

    //@Query("SELECT * FROM user u WHERE u.username = :username")
    //User findById(String username);
}
