package com.ecom.product.Service;

import com.ecom.product.Entity.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto addCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategory();
    void deleteCategory(Integer id);

}
