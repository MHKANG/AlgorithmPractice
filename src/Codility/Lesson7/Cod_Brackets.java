package Codility.Lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Cod_Brackets {
	public static void main(String[] args) {
		int answer = 1;
		String S = "{[()()]}";
		List<Character>open = new ArrayList<Character>();
		open.add('(');
		open.add('[');
		open.add('{');
		List<Character>close = new ArrayList<Character>();
		close.add(')');
		close.add(']');
		close.add('}');
		
		Stack<Character> stack = new Stack();
		
		for(int i = 0; i < S.length(); i++) {
			if(open.contains(S.charAt(i))) {
				stack.push(S.charAt(i));
			}else {
				if(stack.isEmpty()) {
					answer = 0;
					break;
				}
				if(S.charAt(i) == ')' && stack.pop()!='(') {
					answer = 0;
					break;
				}
				if(S.charAt(i) == ']' && stack.pop()!='[') {
					answer = 0;
					break;
				}
				if(S.charAt(i) == '}' && stack.pop()!='{') {
					answer = 0;
					break;
				}
			}
		}
		
		if(!stack.isEmpty())
			answer = 0;
		
		
		System.out.println(answer);
		
	}
}
