package wang.sichao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.sichao.mapper.UserMapper;
import wang.sichao.pojo.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insert(User user){
        return userMapper.insert(user);
    }
}
