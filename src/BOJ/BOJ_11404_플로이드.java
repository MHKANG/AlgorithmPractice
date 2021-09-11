package BOJ;

import java.util.Scanner;

public class BOJ_11404_플로이드 {
	
	static int M = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][]city = new int[n+1][n+1];
		
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < n+1; j++) {
				city[i][j] = M;
				if(i==j)
					city[i][j] = 0;
			}
		}
		for(int i = 0; i <m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int val = sc.nextInt();
			city[start][end] = Math.min(val, city[start][end]);
		}
		
		for(int k = 1; k<n+1; k++) {
			for(int i =1; i <n+1; i++) {
				if(i ==k)
					continue;
				
				for(int j = 1; j < n+1; j++) {
					if(i==j || j==k)
						continue;
					if(city[i][k]!=M && city[k][j] != M && city[i][j] > city[i][k] + city[k][j]) {
						city[i][j] = city[i][k] +city[k][j];
					}
				}
			}
		}
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(city[i][j] == M) {
					System.out.print(0 +" ");
				}else {
					System.out.print(city[i][j] +" ");
				}
			}
			System.out.println();
		}
		
		
	}
}
