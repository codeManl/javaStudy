package cn.liulele.behaviorPatterns.statePattern;

/**
 * @author 刘乐乐
 * @description 状态接口,在这里声明不同状态的操作
 * @date 2022-05-06 20:43:27
 */
public interface State {
    /**
     * 花费积分
     */
    void speedCredits();

    /**
     * 抽奖 返回抽奖结果
     */
    boolean raffle();

    /**
     * 发放奖品,返回剩余奖品的数量
     */
    int giveOutPrizes();
}
