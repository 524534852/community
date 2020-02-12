package bristol.yhj.community.service;

import bristol.yhj.community.dao.UserMapper;
import bristol.yhj.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserbyId(int id)
    {
        return userMapper.selectById(id);
    }
}
