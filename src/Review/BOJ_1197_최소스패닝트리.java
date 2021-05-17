package Review;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1197_최소스패닝트리 {
	
	static int[] roots;
	static int[] rank;
	static int V, E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		roots = new int[V+1];
		rank  = new int[V+1];
		long[][]edges = new long[E][3];
		
		for(int i = 0; i < E; i++) {
			edges[i][0] = sc.nextLong();
			edges[i][1] = sc.nextLong();
			edges[i][2] = sc.nextLong();
		}
		
		Arrays.sort(edges, new Comparator<long[]>() {
			
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[2], o2[2]);
			}
		});
		
		for(int i = 1; i < V+1 ; i++) {
			makeSet(i);
		}
		int cnt = 0;
		int result = 0;
		for(int i = 0; i < E; i++) {
			int a = findSet((int)edges[i][0]);
			int b = findSet((int)edges[i][1]);
			
			if(a == b)
				continue;
			
			union(a,b);
			
			result += edges[i][2];
			// 정점의 수 -1 반복하면 그만한다.
			cnt++;
			if(cnt == V-1)
				break;
		}
		System.out.println(result);
	}
	
	// 유니온 find
	static void makeSet(int x) {
		roots[x] = x;
	}
	// 트리에 있는 root node를 검색
	static int findSet(int x) {
		if(roots[x] == x) {
			return x;
		}else {
			roots[x] = findSet(roots[x]);
			return roots[x];
		}
	}
	// union find
	
	static void union(int x, int y) {
		int rx = findSet(x);
		int ry = findSet(y);
		
		if(rank[rx] > rank[ry]) {
			roots[ry] = rx;
		}else {
			roots[rx] = ry;
			if(rank[rx]== rank[ry]) {
				rank[ry]++;
			}
		}
	}
}
