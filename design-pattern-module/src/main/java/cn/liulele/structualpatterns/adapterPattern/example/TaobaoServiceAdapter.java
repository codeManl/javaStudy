package cn.liulele.structualpatterns.adapterPattern.example;

/**
 * @author liuele
 * @description
 * @date 2022/8/17 21:28:28
 */
public class TaobaoServiceAdapter implements OrderServiceAdapter {
    TaobaoService taobaoService = new TaobaoService();

    @Override
    public boolean isFirst(String userId) {
        return taobaoService.queryUserCount(userId) <= 1;
    }
}
