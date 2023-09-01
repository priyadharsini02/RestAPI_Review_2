package com.example.inventorycrud_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.inventorycrud_2.entity.CategoryEntity;
import com.example.inventorycrud_2.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    //post
    public CategoryEntity saveinfo(CategoryEntity categoryEntity) {
		return categoryRepository.save(categoryEntity);
	}
    
    //post n items
    public CategoryEntity savelist(CategoryEntity categoryEntities){
    	return  categoryRepository.save(categoryEntities);
    }
    
    //get
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    //get by id
    public Optional<CategoryEntity> getAllCategoriesById(Long id){
    	return categoryRepository.findById(id);
    }
    
    //update
    public CategoryEntity changeinfo(CategoryEntity categoryEntity) {
		return categoryRepository.saveAndFlush(categoryEntity);
	}
	
    //update by id
	public String updateinfobyid(Long id,CategoryEntity categoryEntity) {
		categoryRepository.saveAndFlush(categoryEntity);
		if(categoryRepository.existsById(id)) {
			return "UPDATED";
		}
		else {
			return "Enter valid id";
		}
	}
	
	//deleteAll
		public void deleteall() {
			categoryRepository.deleteAll();
		}
		
		//delete by id path variable
		public void deleteid(Long id) {
			categoryRepository.deleteById(id);
		}
		//request par
		public void deletepid(Long id) {
			categoryRepository.deleteById(id);
		}
}

