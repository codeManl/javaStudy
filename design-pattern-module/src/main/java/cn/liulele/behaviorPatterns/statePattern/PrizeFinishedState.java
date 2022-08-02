package cn.liulele.behaviorPatterns.statePattern;

/**
 * @author 刘乐乐
 * @description 奖品领完状态
 * @date 2022-05-06 20:53:50
 */
public class PrizeFinishedState extends AbstractState {


    public PrizeFinishedState(Activity activity) {
        super(activity);
    }

    @Override
    public void speedCredits() {
        System.out.println("当前活动已结束");
    }

    @Override
    public boolean raffle() {
        System.out.println("当前活动已结束");
        return false;
    }

    @Override
    public int giveOutPrizes() {
        System.out.println("当前活动已结束");
        return 0;
    }
}
