package SAMSUNGSW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 삼성SW_스타트와링크 {
	static int N;
	static int[][] abil;
	static int answer;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		answer = 11000;
		
		abil = new int[N][N];
		input = new int[N];
		for(int i = 0; i < N;i++) {
			input[i] = i;
			
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				abil[i][j] = sc.nextInt();
			}
			
		}
		combi(N, N/2, 0, 0, new int[N/2]);
		
		System.out.println(answer);
	}
	
	public static  void combi(int N, int R, int cnt, int cur,  int[]select) {
		
		if(cnt==R) {

			List<Integer>teamStart = new ArrayList<>();
			List<Integer>teamLink = new ArrayList<>();
			boolean[] check = new boolean[N];
			for(int i = 0; i < select.length; i++) {
				if(checkContain(input, select[i])) {
					check[select[i]] = true;
				}
			}
			for(int i = 0; i < check.length; i++) {
				if(check[i]) {
					teamStart.add(i);
				}else {
					teamLink.add(i);
				}
			}
			if(answer > Math.abs(sumTeam(teamStart)-sumTeam(teamLink))) {
				answer = Math.abs(sumTeam(teamStart)-sumTeam(teamLink));
			}
			
			return;
		}
		
		for(int i = cur; i < N; i++) {
			select[cnt] = input[i];
			combi(N, R, cnt+1, i+1, select);
		}
		
	}
	public static void printList(List<Integer>input) {
		for(int i = 0; i < input.size(); i++) {
			System.out.print(input.get(i)+" ");
		}
		System.out.println();
	}
	
	public static boolean checkContain(int[]input, int n) {
		for(int i = 0; i < input.length; i++) {
			if(input[i] == n) {
				return true;
			}
		}
		return false;
	}
	
	public static int sumTeam(List<Integer>input) {
		int result = 0;
		
		for(int i = 0; i < input.size()-1;i++) {
			for(int j = i+1; j < input.size(); j++) {
				result += abil[input.get(i)][input.get(j)] + abil[input.get(j)][input.get(i)];
			}
		}
		
		return result;
	}
	
}
