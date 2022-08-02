package cn.liulele.behaviorPatterns.statePattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-06 21:54:58
 */
public class StatePatternTest {
    public static void main(String[] args) {

        Activity activity = new Activity(3);
        for (int i = 0; i < 20; i++) {
            System.out.println();
            System.out.println("第 " + (i + 1) + " 次抽奖开始...");
            activity.speedCredits();

            if (activity.raffle()) {
                activity.giveOutPrizes();
            }
        }
        System.out.println(activity.getProfit());
    }
}
