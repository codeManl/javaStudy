package cn.liulele.structualpatterns.decoratorPattern.example;

/**
 * @author liuele
 * @description
 * @date 2022/9/17 21:30:30
 */
public class LoginSSOInterceptorDecorator extends SSOInterceptorDecorator {

    public LoginSSOInterceptorDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        System.out.println("单点登录拦截器的装饰器触发了");
        boolean res = super.preHandle(request, response, handler);
        if (!res) {
            return false;
        }
        return "success".equals(request.substring(0, 7));
    }
}
