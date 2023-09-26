/**
 * Author : PhearunPhin
 * Date : 9/7/2023
 */

package com.phearun.needhelpAPI.repository;

import com.phearun.needhelpAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
