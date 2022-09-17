package cn.liulele.structualpatterns;

import cn.liulele.structualpatterns.decoratorPattern.example.LoginSSOInterceptorDecorator;
import cn.liulele.structualpatterns.decoratorPattern.example.SSOInterceptor;
import org.junit.Test;

/**
 * @author liuele
 * @description
 * @date 2022/9/17 21:33:33
 */
public class DecoratorTest {


    @Test
    public void testDecorator() {
        String request  = "success";
        String response = "resp";

        LoginSSOInterceptorDecorator interceptorDecorator = new LoginSSOInterceptorDecorator(new SSOInterceptor());
        boolean b = interceptorDecorator.preHandle(request, response, null);
        System.out.println(b);
    }
}
