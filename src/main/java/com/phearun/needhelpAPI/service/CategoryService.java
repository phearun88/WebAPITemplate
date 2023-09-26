/**
 * Author : PhearunPhin
 * Date : 9/7/2023
 */

package com.phearun.needhelpAPI.service;

import com.phearun.needhelpAPI.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category entity);
    Category getById(Integer id);

    Category update(Integer id, Category brand) ;

    List<Category> getCategories();
}
