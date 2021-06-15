package Codility.Lesson05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// reference : https://jackjeong.tistory.com/44
// Task : 100 Correctness : 100 Performance : 100
public class Cod_GenomicRangeQuery_other1 {
	public static void main(String[] args) {
		String S = "CAGCCTA";
		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};
		
		int[]answer = new int [P.length];
		Map<Character, Integer>map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		char[]cary = S.toCharArray();
		int[] count = {0, 0, 0, 0};
		int[][] countAry = new int[cary.length][count.length];
		// String S를 한개의 단어씩 순회하여 Count 값을 올린다.
		/*
		 	ex)
		 	S = CAGCCTA
		 	C : {0, 1, 0, 0}
		 	CA : {1, 1, 0, 0}
		 	CAG : {1, 1, 1, 0}
		 	CAGC: {1, 2, 1, 0}
		 	CAGCC: {1, 3, 1, 0}
		 	이를 2차원 배열에 [[0100], [1100], [1110], [1210]...]로 쌓는다.
		 	이를 이용하여 P[0] = 2, Q[0]= 4일때 4번째 idx에서 1번째 idx를 빼면 값을 찾을 수 있다 -> idx가 0부터 시작하기 때문
		 	-> {1,3,1,0} - {1,1,0,0} = {0,2,1,0} : GCC
		 	-> S의 substring으로 이를 해결하면 S.subString(2, 5)가 현재 원하는 값 GCC인데 
		 	-> 이걸 위의 순회로 쓰면 편하게 구할 수 있다.
		 */
		for(int i = 0; i < cary.length; i++) {
			count[map.get(cary[i])]++;
			for(int j = 0; j < count.length; j++) {
				countAry[i][j] = count[j];
			}
		}
		
		for(int i = 0; i < P.length; i++) {
			for(int j = 0; j < count.length; j++) {
				int end = countAry[Q[i]][j];
				int start = P[i] == 0  ? 0 : countAry[P[i]-1][j];
				
				if(end - start > 0) {
					answer[i] = j+1;
					break;
				}
			}
		}
		
		
		System.out.println(Arrays.toString(answer));
	}
}
