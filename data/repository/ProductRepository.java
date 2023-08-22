package com.trungphap.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trungphap.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product , Long>{

}