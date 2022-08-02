package cn.liulele.behaviorPatterns.iteratorPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-15 16:36:14
 */
public interface Container<E> {

    public Iterator<E> iterator();
}
