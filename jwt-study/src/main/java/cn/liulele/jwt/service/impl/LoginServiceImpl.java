package cn.liulele.jwt.service.impl;

import cn.liulele.jwt.entity.LoginUserDetails;
import cn.liulele.jwt.entity.User;
import cn.liulele.jwt.service.LoginService;
import cn.liulele.jwt.utils.JwtUtil;
import cn.liulele.mybatis.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * @author liulele
 * @description
 * @date 2022/12/5 22:07:07
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private RedisService redisService;


    @Override
    public String login(User user) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());

        Authentication authenticate = manager.authenticate(authentication);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登陆失败");
        }
        LoginUserDetails loginUserDetails = (LoginUserDetails) authenticate.getPrincipal();
        User userInfo = loginUserDetails.getUser();

        String token = JwtUtil.createJWT(userInfo.getId().toString());
        System.out.println(token);

        redisService.setCacheObject(userInfo.getId().toString(), userInfo);

        return token;
    }

    @Override
    public User logout() {
        // 从SpringSecurityHolder 中获取到用户id
        //从redis中删除用户id(存储是在login时存的，这样删除后再次访问就无法从redis中获取到用户信息，即使使用原有的token也无法访问了，可以看JwtFilter中的逻辑)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        if (Objects.isNull(user)) {
            return null;
        }

        Long id = user.getId();
        redisService.deleteObject(id.toString());
        return user;
    }
}
