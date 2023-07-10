package com.bitsmart.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bitsmart.demo1.model.Category;
@Repository
public interface Categoryrepo extends JpaRepository<Category, Integer> {

}