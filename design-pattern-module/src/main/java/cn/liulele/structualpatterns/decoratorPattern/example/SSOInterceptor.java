package cn.liulele.structualpatterns.decoratorPattern.example;

/**
 * @author liulele
 * @description
 * @date 2022/9/16 17:26:26
 */
public class SSOInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        String success = request.substring(0, 7);
        return "success".equals(success);
    }
}
