
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Internal node class to represent data
    private static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    // Empty this linked list, O(n)
    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    // Return the size of this linked list
    public int size() {
        return size;
    }

    // Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the tail
    public void add(T elem) {
        addLast(elem);
    }

    // Add a node to the tail, O(1)
    public void addLast(T elem) {
        if (elem == null)
            throw new IllegalArgumentException("Null elements are not allowed");

        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Add an element to the beginning, O(1)
    public void addFirst(T elem) {
        if (elem == null)
            throw new IllegalArgumentException("Null elements are not allowed");

        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            head.prev = new Node<>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // Add an element at a specified index
    public void addAt(int index, T data) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Illegal index: " + index);

        if (data == null)
            throw new IllegalArgumentException("Null elements are not allowed");

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node<T> newNode = new Node<>(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    // Check the first element
    public T peekFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Empty list");
        return head.data;
    }

    // Check the last element
    public T peekLast() {
        if (isEmpty())
            throw new NoSuchElementException("Empty list");
        return tail.data;
    }

    // Remove the first element, O(1)
    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Empty list");

        T data = head.data;
        head = head.next;
        size--;

        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }

        return data;
    }

    // Remove the last element, O(1)
    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Empty list");

        T data = tail.data;
        tail = tail.prev;
        size--;

        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }

        return data;
    }

    // Remove an arbitrary node, O(1)
    private T remove(Node<T> node) {
        if (node.prev == null)
            return removeFirst();

        if (node.next == null)
            return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;
        node.data = null;
        node.prev = node.next = null;
        size--;

        return data;
    }

    // Remove an element at a particular index, O(n)
    public T removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Illegal index: " + index);

        int i;
        Node<T> trav;

        // Search from the front
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
        } else {
            // Search from the back
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }

        return remove(trav);
    }

    // Remove a particular value
    public boolean remove(Object obj) {
        for (Node<T> trav = head; trav != null; trav = trav.next) {
            if (obj != null && obj.equals(trav.data)) {
                remove(trav);
                return true;
            }
        }
        return false;
    }

    // Find the index of a particular value
    public int indexOf(Object obj) {
        int index = 0;

        for (Node<T> trav = head; trav != null;
             trav = trav.next, index++) {
            if (obj != null && obj.equals(trav.data)) {
                return index;
            }
        }

        return -1;
    }

    // Check whether a value is contained in the list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    // Iterator for enhanced for loops
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // Convert the list to a string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);

            if (trav.next != null) {
                sb.append(", ");
            }

            trav = trav.next;
        }

        sb.append(" ]");
        return sb.toString();
    }

    // Main method to test the linked list
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Add elements
        list.add(10);
        list.add(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println("After adding: " + list);

        // Size and empty check
        System.out.println("Size: " + list.size());
        System.out.println("Is empty? " + list.isEmpty());

        // Peek at first and last elements
        System.out.println("First: " + list.peekFirst());
        System.out.println("Last: " + list.peekLast());

        // Add at a specific index
        list.addAt(2, 15);
        System.out.println("After addAt: " + list);

        // Search
        System.out.println("Index of 20: " + list.indexOf(20));
        System.out.println("Contains 30? " + list.contains(30));
        System.out.println("Contains 99? " + list.contains(99));

        // Remove by value
        list.remove(Integer.valueOf(15));
        System.out.println("After removing 15: " + list);

        // Remove by index
        System.out.println("Removed index 1: " + list.removeAt(1));
        System.out.println("After removeAt: " + list);

        // Remove first and last
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("After end removals: " + list);

        // Iterator / enhanced for loop
        list.add(100);
        list.add(200);

        System.out.println("Iterating:");
        for (int value : list) {
            System.out.println(value);
        }

        // Clear
        list.clear();
        System.out.println("After clear: " + list);
        System.out.println("Is empty? " + list.isEmpty());
    }
}
