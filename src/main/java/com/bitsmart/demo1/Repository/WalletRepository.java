package com.bitsmart.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitsmart.demo1.model.Wallet;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    List<Wallet> findAllByOrderByPriority();
}