package cn.liulele.shardingsphere;

import cn.liulele.shardingsphere.entity.User;
import cn.liulele.shardingsphere.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liulele
 * @description 读写分离测试
 * @date 2022/11/14 20:55:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadWriteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void shouldInsertToMaster() {
        User user = new User();
        user.setUname("张三丰");
        userMapper.insert(user);
    }

    @Test
    public void shouldSelectFromSlave() {
        User user = new User();
        user.setUname("李四");
        userMapper.insert(user);
        List<User> users = userMapper.selectList(null);
    }

    @Transactional
    @Test
    public void shouldSelectFromMasterWithTrans() {
        User user = new User();
        user.setUname("王五");
        userMapper.insert(user);
        List<User> users = userMapper.selectList(null);
    }

    @Test
    public void shouldLoadBalance() {
        for (int i = 0; i < 10; i++) {
            userMapper.selectList(null);
        }
    }
}
