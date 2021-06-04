package Codility.Lesson8;

import java.util.HashMap;
import java.util.Vector;

// Task : 100 Correctness: 100 Performance : 100
// reference : https://lipcoder.tistory.com/entry/EquiLeader-Codility
public class Cod_EquiLeader {
	public static void main(String[] args) {
		int[] A = {4, 3, 4, 4, 4, 2};
		
		int answer = 0;
        int leader = 0, leaderCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
           if(map.containsKey(A[i])) {
        	   map.put(A[i], map.get(A[i])+1);
           }else {
        	   map.put(A[i], 1);
           }
           if(leaderCount < map.get(A[i])) {
        	   leaderCount = map.get(A[i]);
        	   leader = A[i];
           }

        }
        Vector<Integer>record = new Vector<Integer>();
        int cur = 0;
        
        for(int i = 0; i < A.length; i++) {
     	   if(A[i] == leader) {
     		   cur++;
     	   }
     	   record.add(cur);
        }
        
        for(int i = 0; i < A.length-1; i++) {
        	int left = record.elementAt(i); // 왼쪽 부분의 빈도수 leader 빈도수
        	int right = record.lastElement() - left; // 오른쪽 부분의 leader 빈도수
        	
        	int limitEquiLeft = ((i + 1) / 2) + 1; 
        	int limitEquiRight = ((A.length - (i + 1)) / 2) + 1; 
        	
        	if((left >= limitEquiLeft) && (right >= limitEquiRight)) { 
        		answer++; 
        	}

        	
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
