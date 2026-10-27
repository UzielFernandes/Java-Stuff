import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {

    private T[] arr; //initiate array
    private int len = 0; //user thinks array size is this
    private int capacity; //actual array size

    public DynamicArray() { //default capacity (16)
        this(16);
    }

    @SuppressWarnings("unchecked") //Not Necessary but asks Java to suppress any warning messages implying unchecked scenarios
    public DynamicArray(int capacity) { //Literal capacity when we assign via DynamicArray<Integer> = new DynamicArray(so and so)
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity); //throw error if capacity is assigned to less than 0
        }

        this.capacity = capacity; //assigining capacity
        arr = (T[]) new Object[capacity]; //create array object
    }

    public int size() { //return lenght of array
        return len;
    }

    public boolean isEmpty() { //returns true if array empty
        return len == 0;
    }

    private void checkIndex(int index) { //to throw error if index doesnt exist
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + len
            );
        }
    }

    public T get(int index) { //check if suck indexexists and returns the value at said index
        checkIndex(index);
        return arr[index];
    }

    public void set(int index, T elem) { //set value at sent index
        checkIndex(index);
        arr[index] = elem;
    }

    public void clear() { //clear array
        for (int i = 0; i < len; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    @SuppressWarnings("unchecked")
    public void add(T elem) { //to add element
        if (len == capacity) { //the dynamic array thing, if lenght = capacity append another list to it
            capacity = (capacity == 0) ? 1 : capacity * 2;

            T[] newArr = (T[]) new Object[capacity];

            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }

        arr[len] = elem; //and this runs regardless
        len++;
    }

    public T removeAt(int index) { //remove element at said index
        checkIndex(index);

        T removed = arr[index];

        for (int i = index; i < len - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[len - 1] = null;
        len--;

        return removed;
    }

    public boolean remove(Object obj) { //remove given element
        int index = indexOf(obj);

        if (index == -1) {
            return false;
        }

        removeAt(index);
        return true;
    }

    public int indexOf(Object obj) { //return index of element
        for (int i = 0; i < len; i++) {
            if (obj == null) { //if object is null then that case is also done here
                if (arr[i] == null) {
                    return i;
                }
            } else if (obj.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(Object obj) { //to check if list merely contains an elemnt
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() { //goes through the entire data struct
        return new Iterator<T>() {
            private int index = 0; //position of index 

            @Override
            public boolean hasNext() { //as the name suggests.....
                return index < len;
            }

            @Override
            public T next() { //return the next thing
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return arr[index++];
            }
        };
    }

    @Override
    public String toString() { //just display the array in a fancy way [10 , 20, 30]
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

