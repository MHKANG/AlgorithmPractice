package Codility.Lesson07;

import java.util.Stack;

public class Cod_Fish {
	public static void main(String[] args) {
		
		int A[] = {4, 3, 2, 1, 5};
		int B[] = {0, 1, 0, 0, 0};
		
		int answer = 0;

        Stack<Integer>downFish = new Stack<Integer>();

        for(int i = 0; i < A.length; i++){
            if(B[i] == 1)
                downFish.push(A[i]);
            else{
                while(!downFish.isEmpty()){
                    if(downFish.peek() > A[i])
                        break;
                    else   
                        downFish.pop();
                }
                if(downFish.isEmpty())
                    answer++;
            }
        }

        System.out.println(answer + downFish.size());
	}
}
