package com.trungphap.backend.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.trungphap.backend.entity.Category;
import com.trungphap.backend.service.CategoryService;
import com.trungphap.backend.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CategoryImpl implements CategoryService{
    
    private CategoryRepository categoryRepository;
@Override
public Category createCategory(Category category){
    return categoryRepository.save(category);
}

@Override

public Category getCategoryById(Long categoryId) {
    Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
    return optionalCategory.get();
}
@Override
public List<Category> getAllCategorys() {
    return categoryRepository.findAll();
}
@Override
public Category updateCategory(Category category) {
Category existingCategory = categoryRepository.findById(category.getId()).get();
existingCategory.setName(category.getName());
existingCategory.setIsHome(category.getIsHome());
Category updatedCategory = categoryRepository.save(existingCategory);
return updatedCategory;
}
@Override
public void deleteCategory(Long categoryId) {
categoryRepository.deleteById(categoryId);

}
}
