package cn.liulele;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuele
 * @description
 * @date 2022/8/16 22:33:33
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private int port;

    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @RequestMapping(path = "/queryUser", method = RequestMethod.GET)
    public User queryUser(@RequestParam String userId) {
        return new User(userId, "zs", 18, "china");
    }
}
