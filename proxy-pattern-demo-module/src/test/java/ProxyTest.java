import cn.liulele.IUserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liulele
 * @description
 * @date 2022/8/22 19:58:58
 */
@Slf4j
public class ProxyTest {

    @Test
    public void test_IUserDao() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.getUser("100001");
        log.info("测试结果：{}", res);
    }
}
