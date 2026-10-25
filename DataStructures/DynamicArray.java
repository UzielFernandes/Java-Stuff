
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0;
    private int capacity;

    public DynamicArray() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }

        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + len
            );
        }
    }

    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    public void set(int index, T elem) {
        checkIndex(index);
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < len; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    @SuppressWarnings("unchecked")
    public void add(T elem) {
        if (len == capacity) {
            capacity = (capacity == 0) ? 1 : capacity * 2;

            T[] newArr = (T[]) new Object[capacity];

            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }

        arr[len] = elem;
        len++;
    }

    public T removeAt(int index) {
        checkIndex(index);

        T removed = arr[index];

        for (int i = index; i < len - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[len - 1] = null;
        len--;

        return removed;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);

        if (index == -1) {
            return false;
        }

        removeAt(index);
        return true;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (obj == null) {
                if (arr[i] == null) {
                    return i;
                }
            } else if (obj.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");

        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);

            if (i < len - 1) {
                sb.append(", ");
            }
        }

        return sb.append(" ]").toString();
    }

    // Main method: test the DynamicArray
    public static void main(String[] args) {

        DynamicArray<Integer> numbers = new DynamicArray<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Array: " + numbers);
        System.out.println("Size: " + numbers.size());
        System.out.println("First element: " + numbers.get(0));

        numbers.set(1, 25);
        System.out.println("After set: " + numbers);

        numbers.removeAt(0);
        System.out.println("After removing index 0: " + numbers);

        numbers.remove(Integer.valueOf(30));
        System.out.println("After removing 30: " + numbers);

        System.out.println("Contains 25? " + numbers.contains(25));
        System.out.println("Is empty? " + numbers.isEmpty());

        numbers.clear();
        System.out.println("After clearing: " + numbers);
        System.out.println("Is empty? " + numbers.isEmpty());

        // Test automatic resizing
        DynamicArray<Integer> small = new DynamicArray<>(2);
        small.add(100);
        small.add(200);
        small.add(300);

        System.out.println("Resizing test: " + small);
    }
}

