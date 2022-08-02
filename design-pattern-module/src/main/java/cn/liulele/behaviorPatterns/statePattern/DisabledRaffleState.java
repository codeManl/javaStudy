package cn.liulele.behaviorPatterns.statePattern;

/**
 * @author 刘乐乐
 * @description 不能抽奖的状态
 * @date 2022-05-06 20:49:52
 */
public class DisabledRaffleState extends AbstractState {

    public DisabledRaffleState(Activity activity) {
        super(activity);
    }

    @Override
    public void speedCredits() {
        if (activity.getCount() <= 0) {
            System.out.println("当前奖品数量为0,不能抽奖了");
            activity.setState(activity.getPrizeFinishedState());
        }

        System.out.println("花费50积分,可以进行抽奖了...");
        activity.addProfit(50);
        // 切换到可以抽奖状态
        activity.setState(activity.getEnabledRaffleState());

    }
}
