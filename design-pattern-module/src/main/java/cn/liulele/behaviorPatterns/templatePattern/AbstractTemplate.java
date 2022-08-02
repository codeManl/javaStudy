package cn.liulele.behaviorPatterns.templatePattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-10 21:45:49
 */
public abstract class AbstractTemplate {
    public final void make() {
        step1();
        step2();
        step3();
        step4();
        step5();
    }

    private void step1() {
        System.out.println("step1...");
    }
    abstract void step2();

    private void step3() {
        System.out.println("step3...");
    }
    abstract void step4();

    private void step5(){
        System.out.println("step5...");
    }
}
