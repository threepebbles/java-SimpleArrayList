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