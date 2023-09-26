/**
 * Author : PhearunPhin
 * Date : 9/7/2023
 */

package com.phearun.needhelpAPI.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(generator = "category_seq_generator")
    @SequenceGenerator(name = "category_seq_generator", initialValue = 1, sequenceName = "category_seq")
    private Integer id;
    private String name;
    private Integer user_id;
    private Boolean active;

    public Category(String name){
        this.name = name;
    }

}
