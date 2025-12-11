package com.rav3.ecom.controller;

import com.rav3.ecom.model.Product;
import com.rav3.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return  new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = service.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        try {
            service.addProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product existingProduct = service.getProductById(id);
        if (existingProduct == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        service.updateProduct(id, product);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product existingProduct = service.getProductById(id);
        if (existingProduct == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        service.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        List<Product> results = service.searchProducts(keyword);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
