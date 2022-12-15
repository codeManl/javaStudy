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
 * @description 水平分片测试
 * @date 2022/11/14 22:30:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HorizontalFragmentationTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void shouldInsertOrderHorizontal() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId((long) (i + 1));
            order.setOrderNo("11111");
            order.setAmount(new BigDecimal("10000"));
            orderMapper.insert(order);
        }
    }
}
