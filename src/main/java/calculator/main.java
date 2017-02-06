package calculator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class main {

    private static ArrayStack stack;
    static DateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE dd. LLLLLLLL yyyy HH:mm:ss zzz");
    static Date date = new Date();

    public static void main(String[] args) {
        System.out.println("Calculator started - "+ dateFormat.format(date)+".");
        Scanner scn = new Scanner(System.in);
        String[] arggs;
        while (true) {
            String str = scn.nextLine();
            arggs = str.split(" ");
            if(stack == null){
            stack = new ArrayStack(1000);
            }
            run(0, arggs);
            stack.print();
            System.out.println("-----");
        }
    }

    public static void run(int index, String[] array) {
        if (index >= array.length) {
            return;
        }
        if (isNumeric(array[index])) {
            stack.push(Integer.parseInt(array[index]));
            run(index + 1, array);
        } else {
            operators(array[index]);
            run(index + 1, array);
        }
    }

    public static void operators(String string) {
        int numOne;
        int numTwo;
        switch (string) {
            case "+":
                numOne = (int) stack.pop();
                numTwo = (int) stack.pop();
                stack.push(numOne + numTwo);
                break;
            case "-":
                numOne = (int) stack.pop();
                numTwo = (int) stack.pop();
                stack.push(numOne - numTwo);
                break;
            case "*":
                numOne = (int) stack.pop();
                numTwo = (int) stack.pop();
                stack.push(numOne * numTwo);
                break;
            case "/":
                numOne = (int) stack.pop();
                numTwo = (int) stack.pop();
                stack.push(numOne / numTwo);
                break;
        }
    }

    public static boolean isNumeric(String string) {
        try {
            int i = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
