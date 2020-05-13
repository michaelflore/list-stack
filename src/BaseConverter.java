import java.util.Scanner;

public class BaseConverter {
    //Fields
    private final int MIN_BASE = 2;
    private final int MAX_BASE = 9;
    private BaseNumber[] baseNumber;

    //Default constructor
    public BaseConverter() {
        baseNumber = new BaseNumber[3];
        inputPrompt();
    }

    //Prompts user
    private void inputPrompt() {
        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < baseNumber.length; i++) {
            System.out.println("Enter a positive integer (base 10) for number " + (i + 1));
            long number = reader.nextLong();


            System.out.println("Enter base that you wish to convert to (between 2 and 9): ");
            long base = reader.nextLong();

            if(base < MIN_BASE || base > MAX_BASE) {
                System.out.println("Invalid base.");
                break;
            }

            baseNumber[i] = new BaseNumber(number, base);
        }
    }

    //Converts base 10 number to target base
    private String convert(BaseNumber num) {
        long number = num.getNumber();
        long base = num.getBase();

        ListStack<Long> stack = new ListStack<>();

        while (number != 0) {
            stack.push(number % base);
            number = number / base;
        }

        StringBuilder build = new StringBuilder();
        while (!stack.isEmpty()) {
            build.append(stack.peek());
            stack.pop();
        }
        return build.toString();

    }

    //Converts all numbers in array
    private String convertAll() {
        StringBuilder sBuild = new StringBuilder();
        for (int i = 0; i < baseNumber.length; i++) {
            sBuild.append(baseNumber[i].getNumber()
                    + " (Base 10) = " + convert(baseNumber[i])
                    + " (Base " + baseNumber[i].getBase() + ")\n");
        }

        return sBuild.toString();
    }

    //Overridden toString() method
    public String toString() {
        return convertAll();
    }

    //Prints conversion
    public void processAndPrint() {
        System.out.println(this);
    }
}