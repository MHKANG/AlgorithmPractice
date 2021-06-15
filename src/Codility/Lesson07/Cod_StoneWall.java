package Codility.Lesson07;

import java.util.Stack;

public class Cod_StoneWall {
	public static void main(String[] args) {
		int[]H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
		
		int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < H.length; i++){
            while(!stack.isEmpty() && stack.peek()> H[i]){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek() < H[i]){
                stack.push(H[i]);
                answer++;
            }
        }
        System.out.println(answer);
	}
}
