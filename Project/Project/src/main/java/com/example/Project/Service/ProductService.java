package com.example.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.ProductEntity;
import com.example.Project.repo.Productrepo;

@Service
public class ProductService {
    
    @Autowired 
    Productrepo productRepo;

    // Get all products
    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }

    // Add a new product
    public ProductEntity addProduct(ProductEntity product) {
        return productRepo.save(product);
    }

    // Delete a product by ID
    public String deleteProduct(int id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return "Product deleted successfully!";
        } else {
            return "Product not found with ID: " + id;
        }
    }

    // Update product details
    public ProductEntity updateProduct(ProductEntity product, int id) {
        if (productRepo.existsById(id)) {
            ProductEntity existingProduct = productRepo.findById(id).get();
            existingProduct.setName(product.getName());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setRating(product.getRating());
            return productRepo.save(existingProduct);
        }
        return product;
    }
}
