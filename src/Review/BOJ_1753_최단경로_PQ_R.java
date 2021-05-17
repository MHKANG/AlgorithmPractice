package Review;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753_최단경로_PQ_R {
	
	static final int INF = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int K = sc.nextInt();
		List<Edge>[] adj = new ArrayList[V+1];
		boolean[]check = new boolean[V+1];
		Edge[] D = new Edge[V+1];
		for(int i = 1; i < V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		
		PriorityQueue<Edge>pq = new PriorityQueue<>();
		
		for(int i = 1; i < V+1; i++) {
			if( i == K) {
				D[i] = new Edge(i, 0);
			}else {
				D[i] = new Edge(i, INF); 
			}
			pq.add(D[i]);
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			for(Edge next : adj[edge.dest]) {
				if(!check[next.dest] && D[next.dest].weight > D[edge.dest].weight + next.weight) {
					D[next.dest].weight = D[edge.dest].weight + next.weight;
					pq.remove(D[next.dest]);
					pq.add(D[next.dest]);
				}
			}
			check[edge.dest] = true;
		}
		
		for(int i = 1; i < D.length; i++) {
			if(D[i].weight == INF) {
				System.out.println("INF");
			}else {
				System.out.println(D[i].weight);
			}
		}
	}
	
	
	static class Edge implements Comparable<Edge>{
		
		int dest;
		int weight;
		public Edge(int dest, int weight) {
			super();
			this.dest = dest;
			this.weight = weight;
		}
		
		@Override
		public int compareTo (Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
		
	}
}
