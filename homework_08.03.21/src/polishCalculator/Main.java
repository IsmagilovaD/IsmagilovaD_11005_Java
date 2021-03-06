package polishCalculator;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "3 4 5 6 * + -";
        String str1 = "1 +";
        String str2 = "1 2 3 +";
        String str3 = " 1 2 + -";
        String str4 = "2 3 * 4 5 * +";

        polishCalculator(str);
        polishCalculator(str1);
        polishCalculator(str2);
        polishCalculator(str3);
        polishCalculator(str4);

    }

    public static void polishCalculator(String str){
        Stack<Integer> numbers = new Stack<>();
        String operators = "+-*/";
        String[] strNumbers = str.split(" ");

        for (String s : strNumbers) {
            if (tryParseInt(s)) {
                int x = Integer.parseInt(s);
                numbers.push(x);
            } else {
                if (operators.contains(s)) {
                    if (numbers.size() >= 2) {
                        int ans = calculator(s, numbers.pop(), numbers.pop());
                        numbers.push(ans);
                    } else {System.out.println("String is not correct"); return;}
                }
            }
        }
        if (numbers.size() == 1){
            System.out.println(numbers.pop());
        } else System.out.println("String is not correct");

    }

    public static boolean tryParseInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int calculator(String s,int b, int a) {
        switch (s) {
            case "+":
                return a + b;
            case "*":
                return (a * b);
            case "/":
                return a / b;
            case "-":
                return a - b;
            default:
                System.out.println("String is not correct");
                return 0;
        }
    }
}
