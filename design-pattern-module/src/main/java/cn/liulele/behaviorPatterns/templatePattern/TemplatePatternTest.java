package cn.liulele.behaviorPatterns.templatePattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-10 21:49:46
 */
public class TemplatePatternTest {
    public static void main(String[] args) {
        AbstractTemplate concreteA = new ConcreteA();
        concreteA.make();
        System.out.println(">>>>>>>>>>");
        AbstractTemplate concreteB = new ConcreteB();
        concreteB.make();
    }
}
