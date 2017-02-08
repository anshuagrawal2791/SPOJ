import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anshu on 08/02/17.
 */
public class TransformTheExpression_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            String s = scan.next();
            char[] exp = s.toCharArray();
            process(exp,s.length());
        }
    }

    private static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    private static void process(char[] exp, int length) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<length;i++){
            if(isOperand(exp[i]))
                System.out.print(exp[i]);
            else if(exp[i]=='(')
                stack.push(exp[i]);
            else if(exp[i]==')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    System.out.print(stack.pop());
                    stack.pop();
            }
            else{
                while (!stack.isEmpty() && Prec(exp[i]) <= Prec(stack.peek()))
                    System.out.print(stack.pop());
                stack.push(exp[i]);
            }



        }
        while (!stack.isEmpty())
            System.out.print(stack.pop());
        System.out.println();

    }

    private static boolean isOperand(char ch) {
        return (Character.isLetter(ch));
    }
}
