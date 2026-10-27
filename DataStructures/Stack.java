public class Stack {

  private int[] ar; //initialize array
  private int pos = 0; //position of topmost element (i.e lenght of array acc to definition)

  // maxSize is the maximum number of items
  // that can be in the queue at any given time
  public Stack(int maxSize) {
    ar = new int[maxSize];
  }

  // Returns the number of elements insize the stack
  public int size() {
    return pos;
  }

  // Returns true/false on whether the stack is empty
  public boolean isEmpty() {
    return pos == 0;
  }

  // Returns the element at the top of the stack
  public int peek() {
    return ar[pos - 1];
  }

  // Add an element to the top of the stack
  public void push(int value) {
    ar[pos++] = value; //update pos here only
  }

  // Make sure you check that the stack is not empty before calling pop!
  public int pop() {
    return ar[--pos];
  }

  // Example usage
  public static void main(String[] args) {

    Stack s = new Stack(5);

    System.out.println("Enter Elements: ");
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);

    System.out.println("Remove Elements: ");
    System.out.println(s.pop()); // 5
    System.out.println(s.pop()); // 4
    System.out.println(s.pop()); // 3

    System.out.println("Add elements again");
    s.push(3);
    s.push(4);
    s.push(5);

    System.out.println("All Elements: ");
    while (!s.isEmpty()) System.out.println(s.pop());

  }
}