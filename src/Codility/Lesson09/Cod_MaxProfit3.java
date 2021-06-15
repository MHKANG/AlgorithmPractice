package Codility.Lesson09;

import java.util.HashMap;

// task 44 correctness 80 performance 0
public class Cod_MaxProfit3 {
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
//		int[]A = {23171, 21011, 21123, 21013, 21367};
		int[]A = {8,9,3,6,1,2};
		int answer = 0;
        
		HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i <A.length; i++) {
			map.put(A[i], i);
		}
		
		combi(map, A, new int[2], 0, 0);
		if(max < 0) {
			answer = 0;
		}else {
			answer = max;
		}
		
	    System.out.println("max : " + max + " answer : "+ answer);

	}
	public static void combi(HashMap<Integer, Integer>imap, int[]input, int[] result, int cnt, int cur) {
		if(cnt == 2) {
			if(imap.get(result[1]) - imap.get(result[0])>0) {
				max = Math.max(max, result[1]-result[0]);
			}
			
			return;
		}
		for(int i = cur; i < input.length; i++) {
			result[cnt] = input[i];
			combi(imap, input, result, cnt+1, i+1);
		}
	}
}
