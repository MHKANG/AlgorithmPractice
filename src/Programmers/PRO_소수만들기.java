package Programmers;

import java.util.Arrays;

public class PRO_소수만들기 {
	class Solution {
	    
		int totalCount;
	    
	    public int solution(int[] nums) {
	        int answer = -1;
	        
	        totalCount = 0;
	        
	        combi(0, nums, new int[3], 0);
	        
	        answer = totalCount;

	        return answer;
	    }
	    
	    public void combi(int cnt, int[] nums, int[] selects, int cur){
	        if(cnt ==3){
	            int sum = 0;
	            boolean check = true;
	            for(int i = 0; i < selects.length; i++){
	                sum += selects[i];
	            }
	            System.out.println(Arrays.toString(selects));
	            System.out.println("합 : " + sum);
	            
	            for(int i = 2; i < sum; i++){
	                if(sum% i == 0){
	                    check = false;
	                    break;
	                }    
	            }
	            if(check)
	                totalCount++;
	            return;
	            
	        }
	        
	        for(int i = cur; i < nums.length; i++){
	            selects[cnt] = nums[i];
	            combi(cnt+1, nums, selects, i+1);
	        }
	        
	    }
	}
}
