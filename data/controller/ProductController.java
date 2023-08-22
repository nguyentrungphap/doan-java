package com.trungphap.backend.controller;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trungphap.backend.entity.Product;
import com.trungphap.backend.service.ProductService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
@CrossOrigin(origins = {"http://localhost:3000" ,"http://localhost:3001"} , exposedHeaders ="Content-Range")
public class ProductController {
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId) {
        Product Product = productService.getProductById(productId);
        return new ResponseEntity<>(Product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "10") Integer size
    ) {
        if(--page<0){
            page = 0;
        }
        Pageable pageable = PageRequest.of(page ,size);
        Page<Product> products = productService.getAllProducts(pageable);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range","item" + pageable.getOffset()+"-"+(pageable.getOffset()+products.getSize())+"/" +products.getTotalPages());
        return ResponseEntity.ok().headers(headers).body(products.getContent());
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long ProductId, @RequestBody Product Product) {
        Product.setId(ProductId);
        Product updatedProduct = productService.updateProduct(Product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long ProductId) {
        productService.deleteProduct(ProductId);
        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
    }
}
