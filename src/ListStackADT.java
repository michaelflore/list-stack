public interface ListStackADT<T> {
    //Checks if stack is empty
    boolean isEmpty();
    //Throws EmptyStackException if stack is empty
    void ifEmpty() throws EmptyStackException;
    //Adds to stack
    void push(T value);
    //Shows value of top node in stack
    T peek() throws EmptyStackException;
    //Removes top node in stack
    void pop() throws EmptyStackException;
}
