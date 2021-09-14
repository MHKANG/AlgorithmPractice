package AlgorithmPractice;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation_20210914 {
	static int N;
	static int[]p;
	static int totalCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[N];
		for(int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p);
		do{
			System.out.println(Arrays.toString(p));
		}while(nextPermutation()); 
			System.out.println("총 경우의 수: " + totalCnt);
	}
	
	public static boolean nextPermutation() {
		totalCnt++;
		
		int i = N -1;
		// 꼭대기 위치 찾음 (교환할 자리 i-1)을 찾음  1 3 5 4 2 가 있다면 3이 교환할 자리임
		while( i > 0 && p[i-1]>=p[i]) {
			--i;
		}
		if(i == 0) {
			return false;
		}
		
		int j = N -1;
		// i 뒤쪽부터 탐색하며 i-1과  교환할  i-1보다 큰 값 j 찾기 
		// 찾았다면 그 위치를 j에 저장함
		while(p[i-1] >=p[j]) {
			--j;
		}
		// 위치 교환
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		// i이후 숫자들을 최소 값으로 만들어 준다.
		int k = N-1;
		
		//step4 i 뒤에 있는 값들을 오름 차순으로 정렬 한다.
		//큰 수로 되어 있는 상태를 작은 수로 변경 하는 것 ex) 1 4 5 3 2 이라면 i는 5위치이기 때문에 뒤에 3 2를 오름 차순으로 변경
		//이미 내림 차순 정렬 되어 있기 때문에 양 끝 단 부터 하나씩 줄이거나 늘리면서 위치를 교환 해주면 된다.
		while(i<k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			++i;
			--k;
		}
		
		return true;
	}
}
