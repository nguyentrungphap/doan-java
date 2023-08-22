package com.trungphap.backend.service;

// import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.trungphap.backend.entity.Product;

public interface ProductService {
   public Product createProduct(Product Product);
   public Product getProductById(Long ProductId);
   public Page<Product> getAllProducts(Pageable pageable);
   public Product updateProduct(Product Product);
   public void deleteProduct(Long ProductId);
   // public List<Product> getProductsByCondition(String title,Long category);


}
