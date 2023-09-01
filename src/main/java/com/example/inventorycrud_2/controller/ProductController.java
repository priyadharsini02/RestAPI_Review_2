package com.example.inventorycrud_2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.inventorycrud_2.entity.ProductEntity;
import com.example.inventorycrud_2.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
    public ResponseEntity<Page<ProductEntity>> getProductsByField(
            @RequestParam(defaultValue = "productId") String field,     
            @RequestParam(defaultValue = "0") int pageNo,       
            @RequestParam(defaultValue = "4") int pageSize) {   
        Page<ProductEntity> products = productService.getProductsByField(field, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }
	
	@PostMapping("addnproducts")
	public List<ProductEntity> addmultipleproducts(@RequestBody List<ProductEntity> productEntities){
		return productService.savemultipleproducts(productEntities);
	}
	
}
