package Algorithm;

import java.util.ArrayList;

// 소수 판정 법
public class 에라스토네스체 {
	static boolean[] prime;
	static ArrayList<Integer> prime_numbers = new ArrayList<>();
	public static void main(String[] args) {
		int N = 100000; // 구하고 싶은  숫자의 범위
		prime = new boolean [N+1];
		
		// 소수는 false
		// 1은 소수가 아니므로 제외
		prime[0] = prime[1] = true;
		
		for(int i =2; i*i <=N; i++) {
			// prime[i]가 소수라면
			if(!prime[i]) {
				// prime[j] 소수가 아님 표시
				// 소수 본인을 제외한 모든 배수를 소수가 아님으로 판정
				for(int j=i*i; j<=N; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i =1; i <=N; i++) {
			if(!prime[i]) {
				prime_numbers.add(i);
			}
		}
		
	}
}
