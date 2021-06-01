package Codility;

public class Cod_TapeEquilibrium_fail {
	// wrong and time out
	// O(N^2)
	public static void main(String[] args) {
		 
		int[] A = {3, 1, 2, 4, 3};
		
		int min = Integer.MAX_VALUE;

	        for(int i = 0; i < A.length; i++){
	            int P = i+1;

	            int sum1 = 0; 
	            int sum2 = 0;
	            int distance = 0;
	            for(int j = 0; j < P; j++){
	                sum1 += A[j];
	            }
	            for(int j = P; j < A.length; j++ ){
	                sum2 += A[j];
	            }
	            distance = Math.abs(sum2-sum1);
	            min = Math.min(min, distance);
	        }
	        
	        System.out.println(min);
	}
}
