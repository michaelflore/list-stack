public class ListStack<T> implements ListStackADT<T> {
    //Fields
    private StackNode<T> stackTop;

    //Default constructor
    public ListStack() {
        stackTop = null;
    }

    //Overloaded constructor
    public ListStack(StackNode<T> top) {
        stackTop = top;
    }

    //Copy constructor
    public ListStack(ListStack<T> stack) {
        stackTop = null;
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                push((T) stack.peek());
                stack.pop();
            }
        }
        else {
            throw new EmptyStackException();
        }
    }

    //Sets top of stack
    public void setTop(StackNode<T> top) {
        stackTop = top;
    }

    //Retrieves top of stack
    public StackNode<T> getTop() {
        return stackTop;
    }

    //Checks if stack is empty
    public boolean isEmpty() {
        if(stackTop == null) {
            return true;
        }
        return false;
    }

    //Throws EmptyStackException if stack is empty
    public void ifEmpty() throws EmptyStackException {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
    }

    //Adds to stack
    public void push(T value) {
        if(this.isEmpty()) {
            setTop(new StackNode<T>(value, null));
        }
        else {
            StackNode<T> newNode = new StackNode<T>(value, getTop());
            setTop(newNode);
        }
    }

    //Shows value of top node in stack
    public T peek() throws EmptyStackException {
        ifEmpty();
        return getTop().getValue();
    }

    //Removes top node in stack
    public void pop() throws EmptyStackException {
        ifEmpty();
        setTop(getTop().getNext());
    }

    //Overridden toString() method
    public String toString() {

        StringBuilder build = new StringBuilder();

        // Check if stack is not empty
        if (!isEmpty()) {
            StackNode<T> current = stackTop;
            while (current != null) {
                build.append(current.getValue() + " ");
                current = current.getNext();
            }
        }

        return build.toString();
    }
}