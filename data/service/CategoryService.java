package com.trungphap.backend.service;

import com.trungphap.backend.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(Category category);
    public Category getCategoryById(Long categoryId);
    public List<Category> getAllCategorys();
    public Category updateCategory(Category category);
    public void deleteCategory(Long categoryId);
    

}
