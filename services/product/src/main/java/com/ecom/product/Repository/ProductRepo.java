package com.ecom.product.Repository;

import com.ecom.product.Entity.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product , Integer> {
    List<Product> findByCategoryId(Integer categoryId);
}
