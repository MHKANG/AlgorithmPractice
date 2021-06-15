package Codility.Lesson06;

import java.util.HashMap;

public class Cod_Distinct {
	public static void main(String[] args) {
		int[] A = {2, 1, 1, 2, 3, 1};
		
		int answer = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        if(A.length == 0)
            answer = 0;
        else{
            for(int i = 0; i < A.length; i++){
                if(!map.containsKey(A[i])){
                    map.put(A[i], 1);
                }else{
                    map.put(A[i], map.get(A[i])+1 );
                }
            }
        }
        answer = map.size();
        
        System.out.println(answer);
	}
}
