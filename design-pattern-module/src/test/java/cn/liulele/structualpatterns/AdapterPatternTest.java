package cn.liulele.structualpatterns;

import cn.hutool.core.bean.BeanUtil;
import cn.liulele.structualpatterns.adapterPattern.example.*;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

/**
 * @author liuele
 * @description
 * @date 2022/8/17 20:32:32
 */
@Slf4j
public class AdapterPatternTest {

    @Test
    public void MQTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        TaobaoOrder taobaoOrder = new TaobaoOrder();
        taobaoOrder.setOrderDate(new Date());
        taobaoOrder.setSku("taobaoSKU");
        taobaoOrder.setTid("tid_01");
        taobaoOrder.setDesc("tdesc_01");
        taobaoOrder.setTaddress("taddress_01");
        taobaoOrder.setTorderId("torder_01");

        HashMap<String, String> relationshipMap = new HashMap<>();
//        relationshipMap.put("orderDate", "date");
//        relationshipMap.put("torderId", "orderId");
//        relationshipMap.put("tid", "uid");
//        relationshipMap.put("taddress", "address");
//        relationshipMap.put("sku", "sku");

        relationshipMap.put("date", "orderDate");
        relationshipMap.put("orderId", "torderId");
        relationshipMap.put("uid", "tid");
        relationshipMap.put("address", "taddress");
        relationshipMap.put("sku", "sku");

        log.info(taobaoOrder.toString());
        OrderInfo orderInfo = Adapter.filter(BeanUtil.beanToMap(taobaoOrder), taobaoOrder.getClass(), relationshipMap);
        log.info(orderInfo.toString());

    }

    @Test
    public void interfaceTest() {

        String userId = "222";
        OrderServiceAdapter jdServiceAdapter = new JDServiceAdapter();
        boolean first = jdServiceAdapter.isFirst(userId);
        System.out.println(first);

        OrderServiceAdapter taobaoServiceAdapter = new TaobaoServiceAdapter();
        boolean f = taobaoServiceAdapter.isFirst(userId);
        System.out.println(f);
    }
}
