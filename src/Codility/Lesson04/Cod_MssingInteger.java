package Codility.Lesson04;

import java.util.Arrays;

// Task : 100% Crrectness : 100% Performance : 100%
// Time Complexity : O(N) or O(N * log(N))
public class Cod_MssingInteger {
	public static void main(String[] args) {
		int[] A = {1, 3, 6, 4, 1, 2};
		
		int answer = Integer.MAX_VALUE;

        Arrays.sort(A);
        int max = A[A.length-1];
        boolean[] check = new boolean[max+1];
        if(max <= 0)
            answer = 1;
        else{
            
            for(int i = 0; i < A.length; i++){
                if(A[i]> 0){
                    check[A[i]] = true;
                }
            } 
        }

        for(int i = 1; i < check.length; i++){
            if(!check[i]){
                answer = i;
                break;
            }
        }
        if(answer == Integer.MAX_VALUE)
            answer = max+1;
        
        System.out.println(answer);
	}
}
