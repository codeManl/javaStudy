package cn.liulele.behaviorPatterns.iteratorPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-15 16:38:24
 */
public class MyContainer implements Container<String> {

    private final String[] names = {"a1", "a2", "a3", "a4"};

    @Override
    public Iterator<String> iterator() {

        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {

        int index;

        public NameIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
