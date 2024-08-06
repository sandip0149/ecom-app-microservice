package com.ecom.product.Service;

import com.ecom.product.Entity.CategoryDto;
import com.ecom.product.Entity.ProductDto;
import com.ecom.product.ProductApplication;

import java.util.List;

public interface ProductService {

    ProductDto addProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Integer id);

    void deleteProduct(Integer id);

    List<ProductDto> getProductsByCategory(Integer categoryId);

}
