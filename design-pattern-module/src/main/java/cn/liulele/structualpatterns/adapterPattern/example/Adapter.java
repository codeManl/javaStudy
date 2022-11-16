package cn.liulele.structualpatterns.adapterPattern.example;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

/**
 * @author liulele
 * @description
 * @date 2022/8/17 20:19:19
 */
public class Adapter {
    /**
     * @param json
     * @param relationshipMap 外部订单和统一订单的映射关系  key: 外部订单的属性名  value: 统一订单的属性名
     * @return
     */
    public static OrderInfo filter(String json, Class sourceClass, Map<String, String> relationshipMap) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return filter(JSONObject.parseObject(json, Map.class), sourceClass, relationshipMap);
    }

    public static OrderInfo filter(Map jsonMap, Class sourceClass, Map<String, String> relationshipMap) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        OrderInfo orderInfo = new OrderInfo();
        Set<String> relationshipKeySet = relationshipMap.keySet();
        for (String key : relationshipKeySet) {
            Object value = jsonMap.get(relationshipMap.get(key));
            if (value != null) {

                Class<?> returnType = sourceClass.getMethod("get" + relationshipMap.get(key).substring(0, 1).toUpperCase() + relationshipMap.get(key).substring(1)).getReturnType();
                orderInfo.getClass().getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), returnType).invoke(orderInfo, value);
            }
        }

        return orderInfo;
    }
}
