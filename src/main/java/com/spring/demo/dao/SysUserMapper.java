package com.spring.demo.dao;

import com.spring.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuhaojie on 2022/12/31.
 * @version 1.0
 */
@Mapper
@Repository
public interface SysUserMapper {
    User login(String UserName);
}
