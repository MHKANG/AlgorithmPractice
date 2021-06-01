package Codility;

import java.util.Arrays;

//Correctness : 100% , Task Score = 66% Performance : 40% 
//Time Complexity : O( N*M)
public class Cod_MaxCounters {
	public static void main(String[] args) {
		int N = 5;
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		 int[] answer = new int[N];
	     Arrays.fill(answer , 0);
	     
	     for(int i = 0; i < A.length; i++){
	    	 	if(A[i] >= 1 && A[i] <= N){
	                answer[A[i]-1]++;
	            }else if(A[i] == N+1){
	            	int max = findMax(answer);
	                Arrays.fill(answer, max);
	            }
	    	 	System.out.println(Arrays.toString(answer));
	      }
		
	}
	public static int findMax(int[]input) {
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < input.length; i++) {
			max = Math.max(max, input[i]);
		}
		return max;
	}
}
