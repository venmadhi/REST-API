package com.example.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Project.Entity.ProductEntity;
import com.example.Project.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired 
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/update/{id}")
    public ProductEntity updateProduct(@PathVariable int id, @RequestBody ProductEntity product) {
        return productService.updateProduct(product, id);
    }
}
