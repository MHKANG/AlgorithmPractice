package Codility.Lesson07;

import java.util.Stack;

// Task : 100 Correctness : 100 Performance : 100
public class Cod_Nesting {
	public static void main(String[] args) {
		String S = "())";
		
		int answer = 1;

        Stack<Character>stack = new Stack<>();

        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);

            if(c == ')' &&!stack.isEmpty() &&stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        if(!stack.isEmpty()){
            answer = 0;
        }
        System.out.println(answer);
	}
}
