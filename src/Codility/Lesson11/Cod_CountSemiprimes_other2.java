package Codility.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Reference : https://mkki.github.io/codility/2018/05/31/codility-count-semiprimes.html
// Task 100 Correctness 100 Performance 100
// 에러 발생 없음 무슨 차이일까?

public class Cod_CountSemiprimes_other2 {
	public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int M = P.length;
        int[] result = new int[M];
        int[] accSemiprimes = getAccumulatedSemiprimes(N);
        
        for(int i=0; i<M; i++) {
            result[i] = accSemiprimes[Q[i]] - accSemiprimes[P[i] - 1];
        }
        
        return result;
    }
        
    
    private int[] getAccumulatedSemiprimes(int N) {
        ArrayList<Integer> primes = getPrime(N);
        int[] semiprimes = new int[N+1];
        for(int prime1 : primes) {
            for(int prime2 : primes) {
                int semiprime = prime1 * prime2;
                if(semiprime > N) {
                    break;
                }
                semiprimes[semiprime] = 1;
            }
        }
        
        for(int i=1; i<=N; i++) {
            semiprimes[i] +=semiprimes[i-1];
        }
        
        // for(int i : semiprimes) {
        //     System.out.print(i + " ");
        // }
        
        return semiprimes;
    }

    private ArrayList<Integer> getPrime(int N) {
        boolean[] isPrime = new boolean[N+1];
        ArrayList<Integer> primes = new ArrayList<>();
        
        for(int i=2; i*i<=N; i++) {
            if(isPrime[i] == false) {
                for(int j=i*i; j<=N; j+=i) {
                    isPrime[j] = true;
                }
            }
        }
         
        for(int i=2; i<=N; i++) {
            isPrime[i] = !isPrime[i];
        }
        
        for(int i=2; i<=N; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
}
