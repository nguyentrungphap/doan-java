package com.trungphap.backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.trungphap.backend.entity.Product;
import com.trungphap.backend.service.ProductService;
import com.trungphap.backend.repository.ProductRepository;
// import java.util.List;
import java.util.Optional;
// import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
@AllArgsConstructor

public class ProductImpl implements ProductService{
    
    private ProductRepository productRepository;

//     public List<Product> getProductsByCondition(String title,Long category) {
//     if(title != null && category !=null){
//         return productRepository.findByTitleAndCategoryId(title,category);
//     }else if(title != null){
//         return productRepository.findByTitle(title);
//     } else if(category != null){
//         return productRepository.findByCategoryId(category);
//     }else{
//         return new ArrayList<>();
//     }
// }


    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
        }

@Override

public Product getProductById(Long productId) {
Optional<Product> optionalProduct = productRepository.findById(productId);
return optionalProduct.get();
}

@Override
public Page<Product> getAllProducts(Pageable pageable){
    return productRepository.findAll(pageable);
}

@Override

public Product updateProduct(Product product) {
Product existingProduct = productRepository.findById(product.getId()).get();
existingProduct.setTitle(product.getTitle());
existingProduct.setDescription(product.getDescription());
existingProduct.setDiscount(product.getDiscount());
existingProduct.setThumbnail(product.getThumbnail());
existingProduct.setCreated_at(product.getCreated_at());
existingProduct.setUpdated_at(product.getUpdated_at());
existingProduct.setDeleted(product.getDeleted());
existingProduct.setPrice(product.getPrice());
existingProduct.setCategories(product.getCategories());
existingProduct.setGalleries(product.getGalleries());
existingProduct.setOrderDetails(product.getOrderDetails());

Product updatedProduct = productRepository.save(existingProduct);
return updatedProduct;

}@Override
public void deleteProduct(Long productId) {
productRepository.deleteById(productId);

}
}
