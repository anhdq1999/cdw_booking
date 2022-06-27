package com.booking.services.impl;

import com.booking.converter.CategoryConverter;
import com.booking.entity.CategoryEntity;
import com.booking.payload.request.CategoryRequest;
import com.booking.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getAll(){
        return categoryRepository.findAll();
    }

    public CategoryEntity save(CategoryRequest categoryRequest){
        CategoryEntity entity = CategoryConverter.toEntity(categoryRequest);
        return categoryRepository.save(entity);
    }

    public void update(Long id,CategoryRequest categoryRequest){
        CategoryEntity entity= CategoryConverter.toEntity(categoryRequest);
        Optional<CategoryEntity> optional = categoryRepository.findById(id);
        if(optional.isPresent()){
            entity.setId(id);
            categoryRepository.save(entity);
        }
    }
    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

    public CategoryEntity getById(Long id){
         CategoryEntity entity=categoryRepository.findById(id)
                 .orElseThrow(()-> new IllegalArgumentException("Not found category with id:"+id));
         return entity;
    }
}
