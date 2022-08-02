package cn.liulele.behaviorPatterns.statePattern;

import java.util.Random;

/**
 * @author 刘乐乐
 * @description 允许抽奖状态
 * @date 2022-05-06 20:51:05
 */
public class EnabledRaffleState extends AbstractState {

    public EnabledRaffleState(Activity activity) {
        super(activity);
    }

    @Override
    public boolean raffle() {
        Random random = new Random();
        int i = random.nextInt(10);
        if (i < 2) {
            // 抽中 转到发放奖品状态
            System.out.println("恭喜中奖了...");
            activity.setState(activity.getGiveOutPrizeState());
            return true;
        }
        // 抽不中 转到不能抽奖状态
        System.out.println("很抱歉没有中奖...");
        activity.setState(activity.getDisabledRaffleState());
        return false;
    }
}
