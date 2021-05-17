package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_5636_소수부분문자열 {
	
	static int N = 100000;
	static boolean[]prime = new boolean[N+1];
	static ArrayList<Integer>prime_numbers = new ArrayList<>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		prime_check();
		while(true) {
			String num = sc.next();
			
			if(num.charAt(0) == '0' && num.length()==1)
				break;
			for(int i = prime_numbers.size()-1; i>=0; i-- ) {
				if(num.contains(Integer.toString(prime_numbers.get(i)))) {
					System.out.println(prime_numbers.get(i));
					break;
				}
			}
			
		}
		
	}
	
	//10만 밑 소수 만들기 에라스토네스 체 이용
	static void prime_check() {
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i*i <=N; i++) {
			if(!prime[i]) {
				for(int j = i*i; j<=N; j+=i) {
					prime[j] = true;
				}
			}
		}
		for(int i = 0; i <= N; i++) {
			if(!prime[i]) {
				prime_numbers.add(i);
			}
		}
	}
}
