package cn.liulele;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liulele
 * @description
 * @date 2022/8/16 22:03:03
 */
@Aspect
@Component
@Slf4j
public class DoJoinPoint {

    @Autowired
    private StarterService starterService;

    @Pointcut("@annotation(cn.liulele.DoDoor)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object doRouter(ProceedingJoinPoint jp) throws Throwable {
        Method method = getMethod(jp);
        DoDoor doDoor = method.getAnnotation(DoDoor.class);
        String value = getFiledValue(doDoor.key(), jp.getArgs());
        log.info("自定义注解处理了方法,方法名: {},方法参数: {} ", method.getName(), value);

        if (value == null || "".equals(value)) {
            return jp.proceed();
        }
        String[] split = starterService.split(",");
        for (String s : split) {
            if (s.equals(value)) {
                return jp.proceed();
            }
        }
        return returnObject(doDoor, method);


    }

    private Object returnObject(DoDoor doGate, Method method) throws IllegalAccessException, InstantiationException {
        Class<?> returnType = method.getReturnType();
        String returnJson = doGate.returnJson();
        if ("".equals(returnJson)) {
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }

    private String getFiledValue(String filed, Object[] args) {
        String filedValue = null;
        for (Object arg : args) {
            try {
                if (null == filedValue || "".equals(filedValue)) {
                    filedValue = BeanUtils.getProperty(arg, filed);
                } else {
                    break;
                }
            } catch (Exception e) {
                if (args.length == 1) {
                    return args[0].toString();
                }
            }
        }
        return filedValue;
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        return getClass(jp).getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    private Class<?> getClass(JoinPoint jp) {
        return jp.getTarget().getClass();
    }
}
