package com.cwru.platform.dao;

import com.cwru.platform.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //我发布的帖子，传入用户id offset:每页起始行的行号 limit 每页多少数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    int selectDiscussPostRows(@Param("userId")int userId);



}
