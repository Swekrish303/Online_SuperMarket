package com.bitsmart.demo1.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitsmart.demo1.model.User;
import com.bitsmart.demo1.model.WishList;

import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<WishList, Integer> {

    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);



}
