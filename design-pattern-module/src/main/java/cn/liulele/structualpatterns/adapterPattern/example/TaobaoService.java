package cn.liulele.structualpatterns.adapterPattern.example;

/**
 * @author liuele
 * @description
 * @date 2022/8/17 21:18:18
 */
public class TaobaoService  {

    public int queryUserCount(String tid) {
        return new TaobaoDao().queryUserOrderCount(tid);
    }


}
