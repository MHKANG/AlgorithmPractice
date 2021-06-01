package Codility;

import java.util.Arrays;

//Correctness : 100% , Task Score = 66% Performance : 40% 
//Time Complexity : O( N*M)
public class Cod_MaxCounters_other1 {
	public static void main(String[] args) {
		int N = 5;
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		int currentMax = 0;
		int lastCalledMax = 0;
		int[] answer = new int[N];
		
		for(int i = 0; i < A.length; i++) {
			if(A[i] == N+1) {
				lastCalledMax = currentMax;
			}else {
				int counter = A[i]-1;
				// 실제로 maxCounter가 수행되지 않았지만 수행된 것 처럼 간주해야 하기 때문에 maxCounter가 진행된
				// 시점에서 가장 큰 값 lastCalledMax 값에 1을 더한 값으로 갱신 해주어야 한다.
				
				if(answer[counter] < lastCalledMax) {
					answer[counter] = lastCalledMax +1;
				}else {
					answer[counter]++;
				}
				
				if(answer[counter]> currentMax) {
					currentMax = answer[counter];
				}
			}
		}
		// 그리고 마지막에 lastCalledMax 값보다 작은 부분들을 lastMaxCalled로 갱신해주어야 한다.
		// 왜냐하면 위에 조건 문에서 maxCounter를 실행하지는 않았지만 값이 변하는 곳에서는 이를 실행한 것처럼 작업을 했다.
		// 만약 한번도 값의 갱신이 일어나지 않은 index 또는 값의 갱신이 일어났어도 maxCounter가 발생한 시점의 max 값보다 작은 값을 가진 index가 존재한다면
		// 그 값을 당시 lasCalledMax (당시 가장 큰 값)으로 갱신해주어야 최종적으로 모든 index에서 maxCounter가 발생한 것이다.
		for(int i = 0; i < N; i++) {
			if(answer[i] < lastCalledMax) {
				answer[i] = lastCalledMax;
			}
		}
		
	}
	
}
