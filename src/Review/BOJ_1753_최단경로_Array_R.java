package Review;

import java.util.Arrays;
import java.util.Scanner;

// 다익스트라 알고리즘 이용
// 메모리 터짐
public class BOJ_1753_최단경로_Array_R {
	
	static final int INF = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] adjMatrix = new int [V+1][V+1];
		boolean[] check = new boolean[V+1];
		int[] D = new int [V+1];
		
		
		//경로 값 저장 인접 행렬 생성
		for(int i = 0 ; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			adjMatrix[u][v] = w;
		}
		// 다익스트라 알고리즘 위해 모든 거리를 최대 값으로 해놓고 최소 값을 찾아서 나감
		Arrays.fill(D, INF);
		// 시작점의 위치를 정하기 위해 거리 값을 0으로 만듬
		D[K] = 0;
		for(int i = 1; i < V; i++) {
			// 최소 값을 구하기 위해 비교 변수 생성
			int min = INF;
			// 최소 거리가 있는 위치를 구하기 위한 변수 생성
			int index = -1;
			
			// 정점의 인덱스가 1부터이기 때문에 1부터 V+1까지 반복문 실행
			for(int j=1; j < V+1; j++) {
				// 방문하지 않은 정점이고 거리 값이 비교 변수 값보다 작을때 그 작은 값을 세로운 MIN값에 대입
				// 이후 그 위치를 기록
				if(!check[j] && min >D[j]) {
					min = D[j];
					index = j;
				}
				
			}
			// 위치 변수의 값이 변화가 없다면 연결점이 없기 때문에 멈춘다.
			// 이를 통해 D[K]가 0인 지점을 찾고 그 이후로 시작을 한다.
			if(index == -1)
				break;
			
			//처음 위치를 찾고 이제 그 위치로부터 다른 정점과 비교하여 방문하지 않고 거리가 가장 작은 값을 찾는 것을 시작
			for(int j = 1; j < V+1; j++) {
				// 방문하지 않았고 , 연결 정점이 있으며 , 만약 거쳐온 거리 값이 현재 정점의 거리 보다 작다면 값을 갱신한다.
				if(!check[j] && adjMatrix[index][j] != 0 && D[index]+ adjMatrix[index][j] <D[j]) {
					D[j] = D[index] + adjMatrix[index][j];
				}
			}
			// 그리고 갱신한 위치를 방문했다고 표기 한다.
			check[index] = true;
		}
		
		for(int i = 1; i < V+1; i++) {
			if(D[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(D[i]);
			}
		}
		
		
	}
}
