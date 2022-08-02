package cn.liulele.behaviorPatterns.statePattern;

/**
 * @author 刘乐乐
 * @description 抽象类,不同状态的默认实现
 * @date 2022-05-06 20:48:49
 */
public abstract class AbstractState implements State{

    protected Activity activity;

    public AbstractState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void speedCredits() {
        throw new RuntimeException("当前状态不支持该操作");
    }

    @Override
    public boolean raffle() {
        throw new RuntimeException("当前状态不支持该操作");
    }

    @Override
    public int giveOutPrizes() {
        throw new RuntimeException("当前状态不支持该操作");
    }
}
