package com.bitsmart.demo1.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitsmart.demo1.model.AuthenticationToken;
import com.bitsmart.demo1.model.User;

@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);
    AuthenticationToken findByToken(String token);

}
