package cn.liulele.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Random;

/**
 * @author liuele
 * @description
 * @date 2022/9/23 0:02:02
 */
@Scope("prototype")
@RestController
public class RedisController {

    private static final String SKU_PRE = "sku:";
    private static final String SKU_USER_PRE = "sku_user:";

    @Autowired
    private JedisPool jedisPool;

    @PostMapping("/redis/seckill/{pid}")
    public String testSecKill(@PathVariable("pid") Long pid) {

        // 多个用户购买同一商品,每个用户只可以购买一件,商品数量有限，卖完即止
        try (Jedis jedis = jedisPool.getResource()) {
            Random random = new Random();
            String uid = String.valueOf(random.nextInt(1000));
            // 库存key: sku:1001  value 库存数量
            String skuKey = SKU_PRE + pid;
            // 购买成功的用户key: sku:user:1001 value: 购买成功的用户uid
            String skuUserKey = SKU_USER_PRE + pid;

            if (jedis.sismember(skuUserKey, uid)) {
                System.out.println("该用户已购买过了,用户uid: " + uid);
                return "该用户已购买过了,用户uid: " + uid;
            }

            // 开始购买
            // 1、判断库存是否足够
            // 2、购买
            // 3、购买成功时将用户id存入redis中

            String s =  jedis.get(skuKey);
            if (s == null || Integer.parseInt(s) <= 0) {
                // 卖完了
                System.out.println("商品已经售空");
                return "商品已经售空";
            }
            Transaction multi = jedis.multi();
            // 库存减一
            multi.decr(skuKey);
            //购买成功保存用户id
            multi.sadd(skuUserKey, uid);
            System.out.println("用户id: " + uid + " 购买成功");
            List<Object> execResult = multi.exec();
            if (execResult == null  || execResult.size()==0) {
                //失败了
                return "购买失败";
            }
            return "用户id: " + uid + " 购买成功";

        }


    }
}
