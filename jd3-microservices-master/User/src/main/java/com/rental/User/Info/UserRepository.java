package com.rental.User.Info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String userName);
    User getByUsernameAndPassword(String userName, String password);
    Boolean existsByUsername(String username);
    Boolean existsByUsernameAndPassword(String username, String password);
}
