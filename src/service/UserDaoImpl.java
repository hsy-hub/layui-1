package service;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.HashMap;
import java.util.List;
@Service
public class UserDaoImpl implements UserDao{
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public Integer userCount() {
        return userMapper.userCount();
    }

    @Override
    public List<User> getUserList2(HashMap map) {
        return userMapper.getUserList2(map);
    }

    @Override
    public int updateUserList(User user) {
        return userMapper.updateUserList(user);
    }


}
