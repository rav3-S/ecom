package com.rav3.ecom.repository;

import com.rav3.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
