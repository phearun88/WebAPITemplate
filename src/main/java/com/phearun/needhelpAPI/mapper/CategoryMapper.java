/**
 * Author : PhearunPhin
 * Date : 9/7/2023
 */

package com.phearun.needhelpAPI.mapper;

import com.phearun.needhelpAPI.dto.CategoryDTO;
import com.phearun.needhelpAPI.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category toEntity(CategoryDTO dto);
    CategoryDTO toDTO(Category entity);

}
