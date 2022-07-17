import java.util.Stack;

class Leet150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            try {
                int parsedInt = Integer.parseInt(token);
                stack.push(parsedInt);
            } catch (Exception e) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (token.equals("+")) {
                    stack.add(num1+num2);
                } else if (token.equals("-")) {
                    stack.add(num1-num2);
                } else if (token.equals("*")) {
                    stack.add(num1*num2);
                } else {
                    stack.add(num1/num2);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"})); // 9
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"})); // 6
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); // 22
    }
}
