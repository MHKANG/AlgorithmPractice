package Codility.Lesson09;

import java.util.Arrays;

// Task : 53 Correctness : 100 Performance : 14
public class Cod_MaxDoubleSliceSum {
	
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		int[]A = {3, 2, 6, -1, 4, 5, -1, 2};
		
		
		int answer = Integer.MIN_VALUE;

        
        combi(A, new int[3], 0, 0);
        
        answer = max;
		
        
        System.out.println(answer);
	}
	
	public static void combi(int[]input, int[]result, int cnt, int cur) {
		if(cnt==3) {
			Arrays.sort(result);
			max = Math.max(sumSlice(input, result[0], result[1], result[2]), max);
			return;
		}
		
		for(int i = cur; i < input.length; i++) {
			result[cnt] = i;
			combi(input, result, cnt+1, i+1);
		}
	}
	
	public static int sumSlice(int[] input, int X, int Y, int Z) {
		int result = 0;
		
		for(int i = X+1; i < Y; i++) {
			result += input[i];
		}
		
		for(int i = Y+1; i < Z; i++) {
			result += input[i];
		}
		
		return result;
	}
	
}
