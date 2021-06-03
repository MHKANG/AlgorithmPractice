package Codility.Lesson8;

import java.util.HashMap;


//Task : 100 Correctness : 100 Performance : 100

public class Cod_Dominator {
	public static void main(String[] args) {
		int []A = {3, 4, 3, 2, 3, -1, 3, 3};
		int answer = 0;

        HashMap<Integer, Integer>map = new HashMap<>();

        for(int i = 0; i < A.length; i++){
            if(!map.containsKey(A[i])){
                map.put(A[i], 1);
            }else {
                map.put(A[i],map.get(A[i])+1);
            }
        }
        int max = Integer.MIN_VALUE;
        int dominatorNum = 0;
        for(int key : map.keySet()){
        	
            if(map.get(key) > max){
                max = map.get(key);
                dominatorNum = key;
            }
        }

        int maxCount = 0;
        boolean checkDominator = true;
        if(max <= A.length/2) {
        	checkDominator = false;
        }

        if(checkDominator){
            for(int i = 0; i < A.length; i++){
                if(dominatorNum == A[i]){
                    answer = i;
                    break;
                }
            }
        }else{
            answer = -1;
        }
        
        System.out.println(answer);
		
	}
}
