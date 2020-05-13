public class EmptyStackException extends StackException {
    public EmptyStackException() {
        super("Error: Stack is empty");
    }

    public EmptyStackException(String message) {
        super(message);
    }
}