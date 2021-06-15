package Codility.Lesson02;

import java.util.HashMap;
import java.util.Iterator;

public class Cod_OddOccurrencesInArray {
	public static void main(String[] args) {
		int[] A = {9,3,9,3,9,7,9};
		
		int answer = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < A.length; i++) {
			if(!map.containsKey(A[i])) {
				map.put(A[i], 1);
			}else {
				map.put(A[i], map.get(A[i])+1);
			}
		}
		
		Iterator<Integer> mapIter = map.keySet().iterator();
		
		while(mapIter.hasNext()) {
			Integer key = mapIter.next();
			Integer value = map.get(key);
			if(value%2 ==1) {
				answer = key;
				break;
			}
			
			
		}
		
		System.out.println(answer);
		
	}
}
