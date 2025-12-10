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

    public Product addProduct(Product product) {
        return dao.save(product);
    }

    public void updateProduct(int id, Product product) {
        if(dao.existsById(id)) {
            product.setId(id);
            dao.save(product);
        }
    }

    public void deleteProduct(int id) {
        dao.deleteById(id);
    }
}
