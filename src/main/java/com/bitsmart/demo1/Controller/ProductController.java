package com.bitsmart.demo1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitsmart.demo1.Repository.Categoryrepo;
import com.bitsmart.demo1.common.ApiResponse;
import com.bitsmart.demo1.dto.ProductDto;
import com.bitsmart.demo1.model.Category;
import com.bitsmart.demo1.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@Autowired
	Categoryrepo categoryrepo;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
		Optional<Category>optionalCategory= categoryrepo.findById(productDto.getCategoryId());
		if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
		  	productService.createProduct(productDto, optionalCategory.get());
	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
	}
	        @GetMapping("/")
	        public ResponseEntity<List<ProductDto>> getProducts() {
	            List<ProductDto> products = productService.getAllProducts();
	            return new ResponseEntity<>(products, HttpStatus.OK);
	        }
	        @PostMapping("/update/{productId}")
	        public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
	            Optional<Category> optionalCategory = categoryrepo.findById(productDto.getCategoryId());
	            if (!optionalCategory.isPresent()) {
	                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
	            }
	            productService.updateProduct(productDto, productId);
	            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been updated"), HttpStatus.OK);
	        }
	
}
