package Codility.Lesson10;

import java.util.ArrayList;
import java.util.List;

// Task 100 Correctness 100 Performance 100

public class Cod_Peaks {
	public static void main(String[] args) {
		int[] A = {1, 3, 2, 1};
		int answer = 0;
	
		if(A.length<=2){
	        answer = 0;
	    }else {
	    	 List<Integer>peak = new ArrayList<>();
	        for(int i=1; i < A.length-1; i++){
	            if(A[i] > A[i-1] && A[i] >A[i+1])
	                peak.add(i);
	        }
	        if(peak.size()==0) {
	        	answer = 0;
	        }else {
	        	for(int i = peak.size(); i >0; i--) {
	        		if(A.length%i==0) {
	        			int div = A.length/i;
	        			
	        			int pidx = 0;
	        			
	        			for(int j : peak) {
	        				int start = pidx*div;
	        				int end = (pidx+1)*div;
	        				if(j >=start && j<end) {
	        					pidx++;
	        				}
	        			}
	        			if(pidx ==i) {
	        				answer = i;
	        				break;
	        			}
	        		}	        		
	        	}
	        }
            
	       
	    }

	    System.out.println(answer);
	}
}
