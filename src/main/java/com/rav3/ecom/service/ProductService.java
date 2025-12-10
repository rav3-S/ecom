package com.rav3.ecom.service;

import com.rav3.ecom.model.Product;
import com.rav3.ecom.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO dao;

    @Autowired
    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    public Product getProductById(int id) {
        return dao.findById(id).orElse(null);
    }
}
