/**
 * Author : PhearunPhin
 * Date : 9/7/2023
 */

package com.phearun.needhelpAPI.controller;

import com.phearun.needhelpAPI.dto.CategoryDTO;
import com.phearun.needhelpAPI.exception.ApiException;
import com.phearun.needhelpAPI.mapper.CategoryMapper;
import com.phearun.needhelpAPI.model.Category;
import com.phearun.needhelpAPI.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryDTO){
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
        category = categoryService.save(category);
        return ResponseEntity.ok(category);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
        return ResponseEntity.ok(categoryService.getById(id));
    }


    @PutMapping("{id}")
    public ResponseEntity<Category> update(@PathVariable("id") int id, @RequestBody CategoryDTO categoryDTO) throws ApiException {
        Category brand =  CategoryMapper.INSTANCE.toEntity(categoryDTO);
        return ResponseEntity.ok(categoryService.update(id, brand));
    }

    @GetMapping
    public ResponseEntity<?> list(){
        List<CategoryDTO> listCategories = categoryService.getCategories()
                .stream()
                .map(c -> CategoryMapper.INSTANCE.toDTO(c))
                .toList();
        return ResponseEntity.ok(listCategories);
    }




}
