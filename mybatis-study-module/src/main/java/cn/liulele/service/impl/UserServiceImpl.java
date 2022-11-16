package cn.liulele.service.impl;

import cn.liulele.mapper.UserMapper;
import cn.liulele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liulele
 * @description
 * @date 2022/11/7 17:35:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer selectOne(Integer id) {
        return userMapper.selectOne(id);
    }
}
