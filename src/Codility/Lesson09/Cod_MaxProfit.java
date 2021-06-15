package Codility.Lesson09;

// task 66 correctness 60 performance 75
public class Cod_MaxProfit {
	public static void main(String[] args) {
//		int[]A = {23171, 21011, 21123, 21013, 21367};
		int[]A = {8,9,3,6,1,2};
		int answer = 0;

	    int left = 0;
	    int right = 0;
	    int max = Integer.MIN_VALUE;

        if(A.length == 0 || A.length == 1) {
        	answer = 0;
        }else {
        	int l_idx = 0;
	        int r_idx = A.length-1;
	        
	        while(true){
	            left = A[l_idx];
	            right = A[r_idx];

	            if(l_idx >= r_idx){
	                break;
	            }else{
	                if(left > right){
	                    l_idx++;
	                }else{
	                    if(max< right-left){
	                        l_idx++;
	                        max = right-left;
	                    }else{
	                        r_idx--;
	                    }
	                }
	            }
	            
	        }
	        if(max < 0){
	            answer = 0;
	        }else {
	        	answer = max;
	        }
        }
	        
	        
	    System.out.println("max : " + max + " answer : "+ answer);

	}
}
