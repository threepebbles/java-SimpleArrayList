public interface SimpleList<E> {

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