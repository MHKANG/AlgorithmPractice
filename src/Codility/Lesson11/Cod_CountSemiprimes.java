package Codility.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Task 22 Correctness 50 Performance 0

public class Cod_CountSemiprimes {
	public static void main(String[] args) {
		int N = 26;
		int[] P = {1, 4, 16};
		int[] Q = {26, 10, 20};
		int[] answer = new int[P.length];
		boolean[] prime = new boolean[N+1];

        prime[0] = prime[1] = true;

        for(int i = 2; i<=N; i++){
             if(!prime[i]){
                 for(int j = i*i; j <=N; j+=i){
                     prime[j] = true;
                 }
             }
        }
        List<Integer>semi = new ArrayList<>();
        for(int i = 1; i <=N; i++){
            for(int j = 1; j <=i; j++ ){
                if(j*j >i){
                    break;
                }
                if(i%j == 0){
                    int div = i/j;
                    if(j*j == i && !prime[j]){
                        semi.add(i);
                    }else if (!prime[j] && !prime[div]){
                        semi.add(i);
                    }
                }
            }
        }
        Integer[] ary = semi.toArray(new Integer[semi.size()]);
        for(int i = 0; i < P.length; i ++) {
        	int s_idx = 0;
        	int e_idx = 0;
        	boolean s_check = false;
        	boolean e_check = false;
        	for(int j = 0; j < ary.length-1; j++) {
        		if(ary[j]<= P[i] &&ary[j+1]>P[i] &&!s_check) {
        			s_idx = j;
        			s_check = true;
        		}
        		if(ary[j]<=Q[i] && ary[j+1] > Q[i]) {
        			e_check = true;
        			e_idx = j;
        			break;
        		}
        		
        	}
        	System.out.println(s_idx +"   " + e_idx);
        	if(!e_check) {
        		e_idx = ary.length-1;
        	}
        	if(e_idx == s_idx) {
        		answer[i] = 0;
        	}else {
        		answer[i] = e_idx - s_idx +1;
        	}
        }
        
        System.out.println(Arrays.toString(answer));
        
	}
}
