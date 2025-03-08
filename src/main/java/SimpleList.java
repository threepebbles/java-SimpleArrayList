public interface SimpleList<E> {

    static <T extends Number> double sum(SimpleList<T> numbers) {
        double sum = 0;
        final int size = numbers.size();
        for (int i = 0; i < size; i++) {
            sum += numbers.get(i).doubleValue();
        }
        return sum;
    }

    static <T> SimpleList<T> fromArrayToList(T[] array) {
        return new SimpleArrayList<T>(array);
    }

    static <T extends Number> SimpleList<T> filterNegative(SimpleList<T> numbers) {
        SimpleList<T> ret = new SimpleArrayList<>();
        final int size = numbers.size();
        for (int i = 0; i < size; i++) {
            final T value = numbers.get(i);
            if (value.doubleValue() < 0) {
                continue;
            }
            ret.add(numbers.get(i));
        }
        return ret;
    }

    /**
     * PECS(Producer Extends, Consumer Super)
     * <p>
     * ? extends T: Upper Bounded Wildcard. Producer 역할. 읽기 전용.
     * <p>
     * ? super T: Lower Bounded Wildcard: Consumer 역할. 쓰기 전용.
     */
    static <T> void copy(SimpleList<? extends T> src, SimpleList<? super T> dst) {
        final int size = src.size();
        for (int i = 0; i < size; i++) {
            dst.add(src.get(i));
        }
    }

    boolean add(E element);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int indexOf(E element);

    void clear();

    int size();

    boolean contains(E element);

    boolean isEmpty();

    boolean remove(E element);
}