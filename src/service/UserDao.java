package service;

import pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    User login(User user);
    List<User> getUserList();
    Integer userCount();
    List<User> getUserList2(HashMap map);
}
