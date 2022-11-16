package cn.liulele.controller;

import cn.liulele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulele
 * @description
 * @date 2022/11/7 17:36:36
 */
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("selectOne")
    public Integer selectOne() {
        Integer integer = service.selectOne(1);
        System.out.println(integer);
        return integer;
    }
}
