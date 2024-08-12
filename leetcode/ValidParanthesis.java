package leetcode;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        String s= "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        char[] characters = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c:characters){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                if(stack.isEmpty()) return false;
                char top = stack.peek();
                if (c == ')' && top == '(') stack.pop();
                else if (c == '}' && top == '{') stack.pop();
                else if (c == ']' && top == '[') stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
