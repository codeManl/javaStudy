package cn.liulele.creationalPatterns;

import cn.liulele.creationalPatterns.abstractFactoryPattern.example.*;
import org.junit.Test;

/**
 * @author liuele
 * @description
 * @date 2022/8/27 21:11:11
 */
public class AbstractFactoryTest {

    @Test
    public void test() {
        CacheService cacheService = JDKProxy.getProxy(CacheServiceImpl.class, new ClusterACacheAdapter());
        cacheService.set("key1", "value1");
        String value1 = cacheService.get("key1");
        System.out.println(value1);
        CacheService cacheServiceB = JDKProxy.getProxy(CacheServiceImpl.class, new ClusterBCacheAdapter());
        cacheServiceB.set("key2", "value2");
        String value2 = cacheServiceB.get("key2");
        System.out.println(value2);

    }

    @Test
    public void testString() {
        String sql = """
                UPDATE t8_sys_prot_plan
                SET change_type  = $N{change_type},
                    freq         = $S{freq},
                    days         = $N{days},
                    is_not_today = $S{is_not_today},
                    inputuser    = $S{inputuser},
                    upd_date     = $S{upd_date},
                    upd_time     = $S{upd_time}
                WHERE
                    portfolio_id = $N{portfolio_id}
                """;

        System.out.println(sql);
    }
}
