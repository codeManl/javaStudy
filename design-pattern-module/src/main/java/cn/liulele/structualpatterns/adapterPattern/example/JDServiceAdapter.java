package cn.liulele.structualpatterns.adapterPattern.example;

/**
 * @author liuele
 * @description
 * @date 2022/8/17 21:28:28
 */
public class JDServiceAdapter implements OrderServiceAdapter {
    JdService jdService = new JdService();

    @Override
    public boolean isFirst(String userId) {
        return jdService.isFirst(userId, null);
    }
}
