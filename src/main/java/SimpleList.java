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