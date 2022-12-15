package cn.liulele.jwt.controller;

import cn.cn.liulele.base.AjaxResult;
import cn.liulele.jwt.entity.User;
import cn.liulele.jwt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author liulele
 * @description
 * @date 2022/12/5 22:04:04
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user) {

        if (Objects.isNull(user)) {
            return AjaxResult.error("未传入用户信息");
        }

        String jwt = loginService.login(user);

        return AjaxResult.success(null, jwt);


    }


    @PostMapping("/logout")
    public AjaxResult logout() {
        User user  = loginService.logout();
        if (Objects.isNull(user)) {
            return AjaxResult.error("注销失败");
        }
        return AjaxResult.success("用户:["+user.getUserName()+"]注销成功");
    }
}
