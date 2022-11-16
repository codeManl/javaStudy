package cn.liulele.controller;

import cn.liulele.service.OrderService;
import cn.liulele.service.SmallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulele
 * @description
 * @date 2022/11/8 10:05:05
 */
@RestController
public class GroupController {

    @Autowired
    private SmallService smallService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/small/build")
    public void getSmallTable() {
        smallService.generate();
    }

    @PostMapping("/order/build")
    public void getOrderTable() {
        orderService.generate();
    }
}
