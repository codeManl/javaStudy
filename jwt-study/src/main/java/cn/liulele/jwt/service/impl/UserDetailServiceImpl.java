package cn.liulele.jwt.service.impl;

import cn.liulele.jwt.entity.LoginUserDetails;
import cn.liulele.jwt.entity.User;
import cn.liulele.jwt.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author liulele
 * @description
 * @date 2022/12/5 20:37:37
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.selectUserInfoByName(username);

        return new LoginUserDetails(user);
    }
}
