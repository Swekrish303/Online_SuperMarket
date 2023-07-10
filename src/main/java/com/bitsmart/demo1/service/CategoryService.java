package com.bitsmart.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitsmart.demo1.Repository.Categoryrepo;
import com.bitsmart.demo1.model.Category;


@Service
public class CategoryService {
	@Autowired
	Categoryrepo categoryRepo;
    public void createCategory(Category category) {
    	categoryRepo.save(category);
    }
    
    public List<Category> listCategory(){
    	return categoryRepo.findAll();
    }
    
    public void editCategory(int categoryId, Category updateCategory) {
        Category category = categoryRepo.getById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDesc(updateCategory.getDesc());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepo.save(category);
    }
    
    public boolean findById(int categoryId) {
        return categoryRepo.findById(categoryId).isPresent();
    }
}
