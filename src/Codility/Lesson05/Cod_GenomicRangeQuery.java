package Codility.Lesson05;

import java.util.Arrays;

// Time out
// Task : 62 Correctness : 100 Performance : 0
public class Cod_GenomicRangeQuery {
	public static void main(String[] args) {
		String S = "CAGCCTA";
		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};
		
		int[]answer = new int [P.length];
		int[]score = new int[S.length()];
		
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i)=='A')
                score[i] = 1;
            else if(S.charAt(i)=='C')
                score[i] = 2;
            else if(S.charAt(i)=='G')
                score[i] = 3;
            else if(S.charAt(i)=='T')
                score[i] = 4;
		}
		
        for(int i = 0; i < P.length; i++){
            int s_idx = P[i];
            int e_idx = Q[i];
            
            int[] temp = Arrays.copyOfRange(score, s_idx, e_idx+1);
            Arrays.sort(temp);
            answer[i] = temp[0];
            
        }
		System.out.println(Arrays.toString(answer));
	}
}
