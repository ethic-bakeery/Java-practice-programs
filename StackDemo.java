import java.util.Scanner;

class Stack {
    private int[] arr;
    private int capacity;
    private int top;

    public Stack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow: Cannot push element, the stack is full.");
            return;
        }
        arr[++top] = element;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow: Cannot pop element, the stack is empty.");
            return;
        }
        top--;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements from top to bottom:");
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the stack: ");
        int capacity = scanner.nextInt();

        Stack stack = new Stack(capacity);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack top element: " + stack.peek());

        stack.pop();
        stack.push(40);
        stack.display();

        scanner.close();
    }
}
