package com.bryan.dao;

import com.bryan.pojo.User;
import java.util.List;

public interface UserMapper {
    // 新增一条用户数据
    int insertUser();

    // 修改id为1的用户的余额，将其改为2000
    int updateUserById();

    // 删除id为3的用户
    int deleteUserById();

    // 查询id为1的用户
    User selectUserById();

    List<User> selectAllUser();
}
