package cn.liulele.behaviorPatterns.statePattern;

/**
 * @author 刘乐乐
 * @description 活动类 在这里要声明活动具有的所有状态,同时需要提供切换不同状态的方法  初始状态为不能抽奖状态
 * @date 2022-05-06 20:54:17
 */
public class Activity {
    /**
     * 活动当前所处状态
     */
    private State state;

    /**
     * 活动奖品的数量,创建活动时指定
     */
    private int count;
    /**
     * 活动的利润
     */
    private int profit;

    private final State disabledRaffleState = new DisabledRaffleState(this);
    private final State enabledRaffleState = new EnabledRaffleState(this);
    private final State giveOutPrizeState = new GiveOutPrizeState(this);
    private final State prizeFinishedState = new PrizeFinishedState(this);


    public Activity(int count) {
        this.count = count;
        this.profit = 0;
        this.state = getDisabledRaffleState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int subtractCount() {
        this.count -= 1;
        return this.count;
    }

    //  提供不同状态的获取
    public State getDisabledRaffleState() {
        return disabledRaffleState;
    }

    public State getEnabledRaffleState() {
        return enabledRaffleState;
    }

    public State getGiveOutPrizeState() {
        return giveOutPrizeState;
    }

    public State getPrizeFinishedState() {
        return prizeFinishedState;
    }

    public void addProfit(int profit) {
        this.profit += profit;
    }

    public int getCount() {
        return this.count;
    }


    public void speedCredits() {
        state.speedCredits();
    }


    public boolean raffle() {
        return state.raffle();
    }


    public int giveOutPrizes() {
        return state.giveOutPrizes();
    }

    public int getProfit() {
        return this.profit;
    }
}
