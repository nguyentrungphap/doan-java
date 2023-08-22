package com.trungphap.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trungphap.backend.entity.Category;
import com.trungphap.backend.service.CategoryService;
import java.util.List;
import org.springframework.http.HttpHeaders;

@RestController
@AllArgsConstructor
@RequestMapping("api/categories")
@CrossOrigin(origins = {"http://localhost:3000" ,"http://localhost:3001"} , exposedHeaders ="Content-Range")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long Categoryld) {
        Category Category = categoryService.getCategoryById(Categoryld);
        return new ResponseEntity<>(Category, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategorys() {
        List<Category> Categories = categoryService.getAllCategorys();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range","item0-"+ Categories.size()+ "/" + Categories.size());
        return ResponseEntity.ok().headers(headers).body(Categories);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long Categoryld,
            @RequestBody Category Category) {
        Category.setId(Categoryld);
        Category updatedCategory = categoryService.updateCategory(Category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long CategoryId) {
        categoryService.deleteCategory(CategoryId);
        return new ResponseEntity<>("Category successfully deleted!", HttpStatus.OK);
    }
}
