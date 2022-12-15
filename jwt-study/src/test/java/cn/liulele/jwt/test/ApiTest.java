package cn.liulele.jwt.test;

import cn.liulele.jwt.entity.User;
import cn.liulele.jwt.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liulele
 * @description
 * @date 2022/12/5 20:24:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void shouldSelectAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testBCryptPasswordEncoder() {
        System.out.println(passwordEncoder.encode("admin"));
    }

    @Test
    public void testBCryptPasswordEncoder2() {
        System.out.println(passwordEncoder.matches("admin", "$2a$10$HZGoufl9qmysigogpYOuduW2KWpersxVakXfZwSVqvdgwPm/8YiYO"));

    }
}
