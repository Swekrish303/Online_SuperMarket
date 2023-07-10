package com.bitsmart.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitsmart.demo1.Repository.WishlistRepo;
import com.bitsmart.demo1.dto.ProductDto;
import com.bitsmart.demo1.model.User;
import com.bitsmart.demo1.model.WishList;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

	@Autowired
    WishlistRepo wishListRepository;

    @Autowired
    ProductService productService;

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<ProductDto> getWishListForUser(User user) {
        final List<WishList> wishLists = wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDto> productDtos = new ArrayList<>();
        for (WishList wishList: wishLists) {
            productDtos.add(productService.getProductDto(wishList.getProduct()));
        }

        return productDtos;
    }
}
