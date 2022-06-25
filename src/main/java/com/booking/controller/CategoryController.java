package com.booking.controller;

import com.booking.common.Response;
import com.booking.converter.CategoryConverter;
import com.booking.entity.CategoryEntity;
import com.booking.payload.request.CategoryRequest;
import com.booking.payload.response.CategoryResponse;
import com.booking.services.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<CategoryResponse> categorys = categoryService.getAll().stream()
                .map(category -> CategoryConverter.toResponse(category))
                .collect(Collectors.toList());
        return ResponseEntity.ok(Response.success("Get all categorys successfully", categorys));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoryRequest categoryRequest) {
        CategoryEntity entity = categoryService.save(categoryRequest);
        if (entity != null) {
            CategoryResponse response = CategoryConverter.toResponse(entity);
            return ResponseEntity.ok(Response.success("Create a category successfully", response));
        } else {
            return ResponseEntity.internalServerError().body("Create a category failure");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        try {
            categoryService.update(id, categoryRequest);
            return ResponseEntity.ok(Response.success("Update category with id:" + id + " successfully", null));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.internalServerError().body(Response.fail(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            categoryService.delete(id);
            return ResponseEntity.ok(Response.success("Delete category with id:" + id + " successfully", null));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.internalServerError().body(Response.fail(e.getMessage()));
        }
    }
}
