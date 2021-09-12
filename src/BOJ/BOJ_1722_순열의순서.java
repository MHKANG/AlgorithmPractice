package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// reference: https://dundung.tistory.com/60
public class BOJ_1722_순열의순서 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] f = new long[21];
		boolean[] check = new boolean[21]; // 중복 수 체크
		Arrays.fill(f, 1);
		// DP를 통해 각 수에 따른 팩토리얼 구하기
		for(int i = 1; i <=20; i++) {
			f[i] = f[i-1]*i;
		}
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int q = Integer.parseInt(st.nextToken());
		int []a = new int[N];
		
		if(q==2) {
			for(int i = 0; i <N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			long ans = 1;
			for(int i = 0; i < N; i++) {
				for(int j =1; j<a[i]; j++) {
					if(!check[j])
						ans +=f[N-i-1];
				}
				check[a[i]] = true;
			}
			System.out.println(ans);
		}else if(q==1) {
			long k = Long.parseLong(st.nextToken());
			for(int i = 0; i <N; i++) {
				for(int j = 1; j <=N; j++) {
					if(check[j])
						continue;
					if(f[N-i-1] <k) {
						k -=f[N-i-1];
					}
					else {
						a[i] = j;
						check[j] = true;
						break;
					}
				}
			}
			for(int i = 0; i <N; i++) {
				System.out.print(a[i]+" ");
			}
		}
	}
	
	
}
