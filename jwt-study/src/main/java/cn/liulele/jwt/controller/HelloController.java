package cn.liulele.jwt.controller;

import cn.cn.liulele.base.ServiceResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author liulele
 * @description
 * @date 2022/12/3 15:48:48
 */
@RestController
@RequestMapping("/jwt")
public class HelloController {

    @GetMapping("/hello")
    public ServiceResult<String> sayHello() {
        System.out.println("hello");
        return ServiceResult.success("hello");
    }
}
