package com.ecom.product.Service.impl;

import com.ecom.product.Entity.Category;
import com.ecom.product.Entity.CategoryDto;
import com.ecom.product.Repository.CategoryRepo;
import com.ecom.product.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Categoryimpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(Categoryimpl.class);


    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        logger.info("Received CategoryDto: {}", categoryDto);
        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }
}
