package Codility.Lesson8;

import java.util.HashMap;

//Task : 22 Correctness: 40 Performance : 0
public class Cod_EquiLeader {
	public static void main(String[] args) {
		int[] A = {4, 3, 4, 4, 4, 2};
		
		int answer = 0;
		
		for(int i = 0; i < A.length-1; i++){
            HashMap<Integer, Integer> front = new HashMap<>();
            HashMap<Integer, Integer> rear = new HashMap<>();

            for(int j = 0; j <= i; j++){
                if(!front.containsKey(A[j])){
                    front.put(A[j], 1);
                }else{
                    front.put(A[j], front.get(A[j])+1);
                }
            }
            for(int k = i+1; k < A.length; k++){
                 if(!rear.containsKey(A[k])){
                    rear.put(A[k], 1);
                }else{
                    rear.put(A[k], rear.get(A[k])+1);
                }
            }
            
            
            int front_max = findMax(front);
            int rear_max = findMax(rear);
            
            if(front_max == rear_max)
                answer++;
            

        }
        System.out.println(answer);
	}
	public static int findMax(HashMap<Integer, Integer>map){
        int max = -1;
        for(int key : map.keySet()){
        	if(map.get(key) > map.size()/2){
                max = key;
                break;
            }      
        }

        return max;
    }
}
