/**
 * Author : PhearunPhin
 * Date : 9/7/2023
 */

package com.phearun.needhelpAPI.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ApiException extends RuntimeException {

    private HttpStatus status;
    private String message;
}
