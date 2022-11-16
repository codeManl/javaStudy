package cn.liulele.shardingsphere;

import cn.liulele.shardingsphere.entity.Order;
import cn.liulele.shardingsphere.entity.User;
import cn.liulele.shardingsphere.mapper.OrderMapper;
import cn.liulele.shardingsphere.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author liulele
 * @description 垂直分库测试
 * @date 2022/11/14 22:30:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class VerticalShardingTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void shouldShardingInsert() {

        User user = new User();
        user.setUname("aaa");

        userMapper.insert(user);


        Order order = new Order();
        order.setOrderNo("10001");
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal("1000"));

        orderMapper.insert(order);
    }


    @Test
    public void shouldShardingSelect() {

        userMapper.selectList(null).forEach(System.out::println);
        orderMapper.selectList(null).forEach(System.out::println);

    }
}
