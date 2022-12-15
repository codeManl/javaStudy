package cn.liulele.jwt.service;

import cn.liulele.jwt.entity.User;

/**
 * @author liulele
 * @description
 * @date 2022/12/5 22:07:07
 */
public interface LoginService {
    String login(User user);

    User logout();

}
