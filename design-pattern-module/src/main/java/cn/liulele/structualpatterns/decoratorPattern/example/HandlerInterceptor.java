package cn.liulele.structualpatterns.decoratorPattern.example;

/**
 * @author liulele
 * @description
 * @date 2022/9/16 17:24:24
 */
public interface HandlerInterceptor {

    boolean preHandle(String request,String response,Object handler);
}
