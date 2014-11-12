/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Hide Tags Stack Data Structure


 * Use two stacks to implement the function.
 * As the question asking to retrieve the minimum element (getMin()),
 * so we use one stack to keep track of minimum element in each procedure.
 * push: if the value is smaller than the value in minStack, push it to minStack
 * pop: if value being popped out is the top of the minStack, pop minStack as well.
 * */
class MinStack {
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (getMin() == stack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {

        return minStack.peek();
    }
}
