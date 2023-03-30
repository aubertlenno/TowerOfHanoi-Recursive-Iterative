import java.lang.*;

public class Iterative {
    class Stack {
        int capacity;
        int top;
        int arr[];
    }

    // Create Stack
    Stack create(int capacity) {

        Stack stack = new Stack();
        stack.capacity = capacity;
        stack.top = -1;
        stack.arr = new int[capacity];

        return stack;
    }

    //Stack is full when the top is equal
    // to the last index
    boolean isFull(Stack stack) {
        return (stack.top == stack.capacity - 1);
    }

    // To check Stack is empty or not
    boolean isEmpty(Stack stack) {
        return (stack.top == -1);
    }

    //Function to add an item in Stack
    void push(Stack stack, int item) {
        if (isFull(stack))
            return;

        stack.arr[++stack.top] = item;
    }

    //Function to remove an item from Stack
    int pop(Stack stack) {

        if (isEmpty(stack))
            return Integer.MIN_VALUE;

        return stack.arr[stack.top--];
    }

    // Function to move disks between the poles
    void moveDisks(Stack src, Stack dest, char s, char d) {

        int pole1 = pop(src);
        int pole2 = pop(dest);


        if (pole1 == Integer.MIN_VALUE) {

            push(src, pole2);
            move(d, s, pole2);
        } else if (pole2 == Integer.MIN_VALUE) {

            push(dest, pole1);
            move(s, d, pole1);
        } else if (pole1 > pole2) {

            push(src, pole1);
            push(src, pole2);
            move(d, s, pole2);
        } else {

            push(dest, pole2);
            push(dest, pole1);
            move(s, d, pole1);
        }
    }

    void move(char fromPeg, char toPeg, int disk) {

        System.out.println("Move the disk " + disk + " from " + fromPeg + " to " + toPeg);
    }

    void Iterative(int num, Stack src, Stack aux, Stack dest) {

        int i, total_num_of_moves;
        char s = 'L', d = 'R', a = 'M';

        if (num % 2 == 0) {

            char temp = d;
            d = a;
            a = temp;
        }
        total_num_of_moves = (int)(Math.pow(2, num) - 1);

        for (i = num; i >= 1; i--)
            push(src, i);

        for (i = 1; i <= total_num_of_moves; i++) {

            if (i % 3 == 1)
                moveDisks(src, dest, s, d);

            else if (i % 3 == 2)
                moveDisks(src, aux, s, a);

            else if (i % 3 == 0)
                moveDisks(aux, dest, a, d);
        }
    }

    public static void main(String[] args) {

        double startTime = System.currentTimeMillis();

        int num = 3;

        Iterative iter = new Iterative();
        Stack src, dest, aux;

        src = iter.create(num);
        dest = iter.create(num);
        aux = iter.create(num);

        iter.Iterative(num, src, aux, dest);

        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;

        System.out.println("Iterative function run time = " + totalTime + " ms");
    }
}
