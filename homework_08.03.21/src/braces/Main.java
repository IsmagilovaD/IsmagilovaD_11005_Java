package braces;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str ="as[w(w)d+)";
        String str1 = "asdw[dw(das]adw)";
        String str2 = "sdw[dw{dfe}adaw]";
        String str3 = "[]dwd{wdw(s)}";

        bracesChecker(str);
        bracesChecker(str1);
        bracesChecker(str2);
        bracesChecker(str3);
    }
    public static boolean chekBraces(char c1, char c2){
        boolean s;
        if (c1 == ')'){
            s = c2 == '(';
        }else if (c1 == ']'){
            s = c2 =='[';
        } else if (c1 == '}'){
            s = c2 == '{';
        } else {System.out.println("Bad signs"); return false;}
        return s;
    }

    public static void bracesChecker(String str){
        Stack<Character> braces = new Stack<Character>();
        String openBraces = "([{";
        String closeBraces = ")]}";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (openBraces.contains(Character.toString(c))){
                braces.push(c);
            }
            if (closeBraces.contains(Character.toString(c))){
                if (braces.size() == 0){
                    System.out.println("String is not correct");
                    return;
                }
                if (chekBraces(c, braces.peek())){
                    braces.pop();
                }
            }
        }
        if (braces.size() == 0) System.out.println("String is correct");
        else System.out.println("String is not correct");
    }
}
