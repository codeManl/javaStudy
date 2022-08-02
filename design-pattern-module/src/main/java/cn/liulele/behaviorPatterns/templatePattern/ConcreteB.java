package cn.liulele.behaviorPatterns.templatePattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-10 21:48:51
 */
public class ConcreteB extends AbstractTemplate{
    @Override
    void step2() {
        System.out.println("concreteB  step2...");
    }

    @Override
    void step4() {
        System.out.println("concreteB  step4...");
    }
}
