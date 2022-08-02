package cn.liulele.behaviorPatterns.statePattern;

/**
 * @author 刘乐乐
 * @description 发放奖品状态
 * @date 2022-05-06 20:52:05
 */
public class GiveOutPrizeState extends AbstractState {

    public GiveOutPrizeState(Activity activity) {
        super(activity);
    }

    @Override
    public int giveOutPrizes() {
        System.out.println("获得了一件奖品...");
        int i = activity.subtractCount();
        if (i > 0) {
            activity.setState(activity.getDisabledRaffleState());
        }else {
            activity.setState(activity.getPrizeFinishedState());
        }
        return i;
    }
}
