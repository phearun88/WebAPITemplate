/**
 * Author : PhearunPhin
 * Date : 10/20/2023
 */

package com.phearun.needhelpAPI.config.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;

}
