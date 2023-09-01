package com.example.inventorycrud_2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorycrud_2.entity.CategoryEntity;
import com.example.inventorycrud_2.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//post
	@PostMapping("/add")
	public CategoryEntity additems(@RequestBody CategoryEntity categoryEntity) {
		return categoryService.saveinfo(categoryEntity);
	}
	
	//get
	@GetMapping("/show")
	public List<CategoryEntity> showitems(){
		return categoryService.getAllCategories();
	}
	
	//show by id
	@GetMapping("showdetbyid/{id}")
		public Optional<CategoryEntity> showid(@PathVariable Long id){
			return categoryService.getAllCategoriesById(id);
		}
	
	@PutMapping("update")
	public CategoryEntity modify(@RequestBody CategoryEntity ie ) {
		return categoryService.changeinfo(ie);
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable Long id, @RequestBody CategoryEntity categoryEntity) {
		return categoryService.updateinfobyid(id, categoryEntity);
	}
	@DeleteMapping("deletedetail")
		public String del() {
			categoryService.deleteall();
			return "Deleted all";
		}
	
	
	//path variable example
	@DeleteMapping("delid/{id}")
	public String deletemyid(@PathVariable Long id) {
		categoryService.deleteid(id);
		return "Deleted";
	}
	//request parameter example
	@DeleteMapping("delparamid")
	public String deletemyparamid (@RequestParam Long id) {
		categoryService.deletepid(id);
		return "Deleted";
	}
	
}
