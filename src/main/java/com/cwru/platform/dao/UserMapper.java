package com.cwru.platform.dao;

import com.cwru.platform.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


//  selectedById()是接口里的一个方法，返还User类的数据，要不然直接void
    User selectedById(int id);

    User selectedByName(String username);

    User selectedByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);


}
