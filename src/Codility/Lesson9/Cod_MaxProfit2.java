package Codility.Lesson9;

import java.util.Arrays;

// task 66 correctness 100 performance 25
public class Cod_MaxProfit2 {
	public static void main(String[] args) {
//		int[]A = {23171, 21011, 21123, 21013, 21367};
		int[]A = {8,9,3,6,1,2};
		 
		int answer = 0;

	    int max = Integer.MIN_VALUE;
	    
        if(A.length == 0 || A.length == 1) {
        	answer = 0;
        }else {
        	int idx= 0;
        	while(true) {
        		if(idx == A.length-1) {
        			break;
        		}
        		
        		for(int i = idx+1; i < A.length; i++) {
        			max = Math.max(max, A[i]- A[idx]);
        		}
        		idx++;
        	}
        }
	    if(max < 0) {
	    	answer = 0;
	    }else {
	    	answer = max;
	    }
	        
	    System.out.println("max : " + max + " answer : "+ answer);

	}
}
