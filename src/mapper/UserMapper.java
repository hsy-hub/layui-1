package mapper;

import pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    User login(User user);
    List<User> getUserList();
    Integer userCount();
    List<User> getUserList2(HashMap map);
}
