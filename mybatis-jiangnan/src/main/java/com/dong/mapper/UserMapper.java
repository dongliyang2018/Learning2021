package com.dong.mapper;

import com.dong.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {

    public Integer addUser(User user);
    public Integer deleteUserById(Long id);
    public Integer updateUserById(User user);
    public User getUserById(Long id);
    public List<User> getAllUser();
    public List<User> getUserOrderBy(String orderby);

    public List<User> getUserNameContains(String name);

    public Integer updateUsernameById(@Param("username") String username, @Param("id") Long id);

    public Long getUserCount();

    List<User> getAllUsersWithRole();

    List<User> getAllUsersWithRole2();

    List<User> getAllUsersWithRole3();

    public Integer addUser3(User user);

    public List<User> getAllUserByPage(RowBounds rowBounds);
}
