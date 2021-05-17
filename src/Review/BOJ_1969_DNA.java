package Review;

import java.util.Scanner;

public class BOJ_1969_DNA {
	
	static char[] DNA = {'A','C','G','T'};
	static char[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 문자열 개수
		int M = sc.nextInt(); // 문자열 길이
		int result_count = 0; // 해밍 거리 결과 값
		String[] ary = new String[N]; // DNA문자열들을 저장하는 배열
		result = new char[M];
		for(int i = 0; i < N; i++) {
			ary[i] = sc.next();
		}
		for(int i = 0; i < M; i++) {
			int[] DNA_COUNT = new int[4]; // T A C G 가 몇번 나왓는지 저장하는 배열
			int max_index = 0; // 어느것이 가장 많이 나왔는지 위치를 알려 주는 index
			for(int j = 0; j < N; j++) { 
				// 각 스트링의 i 번째 자리에서 4개의 dna 중 가장 무멋이 많이 나왔는지를 카운팅 하는 for문
				if(ary[j].charAt(i) == DNA[0]) {
					DNA_COUNT[0]++;
				}else if(ary[j].charAt(i) == DNA[1]) {
					DNA_COUNT[1]++;
				}else if(ary[j].charAt(i) == DNA[2]) {
					DNA_COUNT[2]++;
				}else if(ary[j].charAt(i) == DNA[3]) {
					DNA_COUNT[3]++;
				}
			}
			int count = 0; // 각 자리수에서 DNA가 몇번 나왔는지 카운팅
			for(int k = 0; k<4; k++) {
				if(DNA_COUNT[k] > count) { // 현재 k번째 
					count = DNA_COUNT[k]; // 
					max_index = k;
				}
			}
			result[i] = DNA[max_index];
			
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(result[j] != ary[i].charAt(j)) {
					result_count++;
				}
			}
		}
		
		for(int i = 0; i <M; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
		System.out.println(result_count);
		
	}
}
