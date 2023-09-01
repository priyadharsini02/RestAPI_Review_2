package com.example.inventorycrud_2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.inventorycrud_2.entity.ProductEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventorycrud_2.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Page<ProductEntity> getProductsByField(String field, int pageNo, int pageSize) {
		Sort sort = Sort.by(field);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return productRepository.findAll(pageable);
	}

	//create multiple products
	public List<ProductEntity> savemultipleproducts(List<ProductEntity> categoryEntities){
    	return (List<ProductEntity>) productRepository.saveAll(categoryEntities);
    }

    //get
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
    //get by id
    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    //create
    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }
    
    //delete
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
