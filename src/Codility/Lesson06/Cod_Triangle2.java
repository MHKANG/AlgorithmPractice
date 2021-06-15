package Codility.Lesson06;

import java.util.Arrays;

// Task: 93 : Correctness : 90 Performance : 100
public class Cod_Triangle2 {
	
	public static void main(String[] args) {
		int[] A = {10, 2, 5, 1, 8, 20};
		int answer = 0;
		
		Arrays.sort(A); // 1, 2, 5, 8, 10 , 20 
		
		
		for(int i = 0; i < A.length-2; i++) {
			Long sum = Long.valueOf(A[i]) + Long.valueOf(A[i+1]);
			Long other = Long.valueOf(A[i+2]);
			if(sum > other) {
				answer = 1;
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	
	
}
