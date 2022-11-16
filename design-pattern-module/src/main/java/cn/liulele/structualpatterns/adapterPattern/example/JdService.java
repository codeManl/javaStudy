package cn.liulele.structualpatterns.adapterPattern.example;

/**
 * @author liulele
 * @description
 * @date 2022/8/17 21:18:18
 */
public class JdService   {

    public boolean isFirst(String jid, String jOrderId) {
        return new JdDao().isFirst();
    }
}
