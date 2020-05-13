public class BaseNumber {

    private long number;
    private long base;

    //Default Constructor
    public BaseNumber() {
        this.number = 0;
        this.base = 10;
    }

    //Overloaded constructor
    public BaseNumber(long num, long b) {
        number = num;
        base = b;
    }

    //Returns number
    public long getNumber() {
        return number;
    }

    //Returns base
    public long getBase() {
        return base;
    }

    //Sets number
    public void setNumber(long num) {
        number = num;
    }

    //Sets base
    public void setBase(long b) {
        base = b;
    }
}
