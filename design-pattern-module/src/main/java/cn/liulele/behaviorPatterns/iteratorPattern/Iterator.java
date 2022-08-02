package cn.liulele.behaviorPatterns.iteratorPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-15 16:34:04
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

}
