package com.spring.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author yuhaojie on 2022/12/31.
 * @version 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Systems {
    private String State;
    private String StartTime;
    private String FinishTime;
}
