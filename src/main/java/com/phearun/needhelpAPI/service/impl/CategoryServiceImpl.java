/**
 * Author : PhearunPhin
 * Date : 9/7/2023
 */

package com.phearun.needhelpAPI.service.impl;

import com.phearun.needhelpAPI.exception.ApiException;
import com.phearun.needhelpAPI.model.Category;
import com.phearun.needhelpAPI.repository.CategoryRepository;
import com.phearun.needhelpAPI.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("brand not found for id=%d", id)));
    }

    @Override
    public Category update(Integer id, Category source) {
        Category target = getById(id);
        BeanUtils.copyProperties(source, target, "id");
        return categoryRepository.save(target);
    }

    @Override
    public List<Category> getCategories() {

        return categoryRepository.findAll();
    }


}
