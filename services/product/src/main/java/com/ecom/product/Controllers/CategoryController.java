package com.ecom.product.Controllers;

import com.ecom.product.Entity.CategoryDto;
import com.ecom.product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryDto> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PostMapping("/category")
    public CategoryDto addCategory(@RequestBody  CategoryDto categoryDto){
       return categoryService.addCategory(categoryDto);
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return "Category Deleted Successfully";
    }


}
