package Codility.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Reference : https://mkki.github.io/codility/2018/05/31/codility-count-semiprimes.html
// Task 66 Correctness 100 Performance 40
// runtime 발생 

public class Cod_CountSemiprimes_other1 {
	public static void main(String[] args) {
		int N = 26;
		int[] P = {1, 4, 16};
		int[] Q = {26, 10, 20};
		int[] answer = new int[P.length];
		boolean[] isprime = new boolean[N+1];

        isprime[0] = isprime[1] = true;

        for(int i = 2; i<=N; i++){
             if(!isprime[i]){
                 for(int j = i*i; j <=N; j+=i){
                     isprime[j] = true;
                 }
             }
        }
        
        List<Integer> prime = new ArrayList<>();
        
        for(int i = 2; i<=N; i++) {
        	if(!isprime[i]) {
        		prime.add(i);
        	}
        }
        
        int[] semiprimes = new int [N+1];
        for(int p1: prime) {
        	for(int p2: prime) {
        		int semiprime = p1 * p2;
        		if(semiprime > N) {
        			break;
        		}
        		semiprimes[semiprime] = 1;
        	}
        }
        // 핵심 알고리즘
        // semiprime수의 개수를 누적시킨다.
        for(int i = 1; i <=N; i++) {
        	semiprimes[i] += semiprimes[i-1];
        }
        
        for(int i = 0; i < P.length; i++) {
        	answer[i] = (semiprimes[Q[i]] - semiprimes[P[i]-1]);
        }
        
        System.out.println(Arrays.toString(answer));
        
	}
}
