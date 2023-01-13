package com.spring.demo.dao;
import com.spring.demo.bean.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
/**
 * @author yuhaojie on 2022/11/7.
 * @version 1.0
 */
public interface WxUserMapper {
    WxUser queryByOpenId(String openId);

    void insertUser(WxUser wxUser);

    int updateUser(WxUser wxUser);

}
