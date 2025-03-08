import java.util.Arrays;
import java.util.Objects;

public class SimpleArrayList<E> implements SimpleList<E> {
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final Object[] EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;
    private int size;

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public SimpleArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public <T> SimpleArrayList(T[] array) {
        this.elementData = array;
    }

    @Override
    public boolean add(E element) {
        add(element, elementData, size);
        return true;
    }

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length) {
            elementData = grow();
        }
        elementData[s] = e;
        size = s + 1;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        final int s = size;
        Object[] tempElements = this.elementData;
        if (s == tempElements.length) {
            tempElements = grow();
        }
        System.arraycopy(tempElements, index,
                tempElements, index + 1,
                s - index);
        tempElements[index] = element;
        size = s + 1;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = ArraysSupport.newLength(oldCapacity,
                minCapacity - oldCapacity,
                oldCapacity >> 1);
        return elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    // Positional Access Operations
    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        E oldValue = elementData(index);
        fastRemove(es, index);
        return oldValue;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize = size - 1;
        if (newSize > i) {
            // 인덱스 i+1부터 newSize-i개(배열의 마지막 원소까지)를 인덱스 i부터 시작하도록 옮김
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }
        es[size = newSize] = null;
        // size는 줄었지만 this.elementData의 실제 크기는 안 줄음
    }

    @Override
    public int indexOf(E element) {
        return indexOfRange(element, 0, size);
    }

    int indexOfRange(E element, int start, int end) {
        Object[] es = elementData;
        if (element == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (element.equals(es[i])) {
                    return i;
                }
            }
        }
        // doesn't exist
        return -1;
    }

    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E element) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (element == null) {
                for (; i < size; i++) {
                    if (es[i] == null) {
                        break found;
                    }
                }
            } else {
                for (; i < size; i++) {
                    if (element.equals(es[i])) {
                        break found;
                    }
                }
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }
}
