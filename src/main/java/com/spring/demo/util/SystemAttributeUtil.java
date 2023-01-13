package com.spring.demo.util;

/**
 * @author yuhaojie on 2022/11/8.
 * @version 1.0
 */

import java.util.UUID;

public class SystemAttributeUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}