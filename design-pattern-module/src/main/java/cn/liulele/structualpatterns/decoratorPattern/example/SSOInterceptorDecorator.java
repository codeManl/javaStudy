package cn.liulele.structualpatterns.decoratorPattern.example;

/**
 * @author liulele
 * @description
 * @date 2022/9/16 17:29:29
 */
public abstract class SSOInterceptorDecorator implements HandlerInterceptor{

    private HandlerInterceptor handlerInterceptor;

    public SSOInterceptorDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request,response,handler);
    }
}
