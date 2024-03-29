package com.spring.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author yuhaojie on 2022/7/15.
 * @version 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private String username;
    private String password;


}
