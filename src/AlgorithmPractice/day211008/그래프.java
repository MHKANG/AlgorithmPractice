package AlgorithmPractice.day211008;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 그래프 {
	static int V;
	static List<Integer>[]graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int edge;
		int start;
		V = sc.nextInt();
		edge = sc.nextInt();
		start = sc.nextInt();
		graph = new List[V+1];
		for(int i = 1; i< V+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i <edge; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			graph[s].add(e);
			graph[e].add(s);
		}
		
		
	}
	public static void dfs(int start) {
		Stack<Integer>st = new Stack<>();
		boolean[]visited = new boolean[V+1];
		List<Integer> path = new ArrayList<>();
		st.push(start);
		
		while(!st.isEmpty()) {
			int top = st.pop();
			
			if(visited[top])
				continue;
			visited[top] = true;
			path.add(top);
			List<Integer>children = graph[top];
			for(int i = children.size(); i>=0; i--) {
				int child = children.get(i);
				if(!visited[child])
					st.push(child);
			}
		}
		System.out.println(path);
	}
	public static void bfs(int start) {
		Queue<Integer>que = new LinkedList<>();
		boolean[]visited = new boolean[V+1];
		List<Integer> path = new ArrayList<>();
		que.offer(start);
		
		while(!que.isEmpty()) {
			int front = que.poll();
			
			if(visited[front])
				continue;
			visited[front]= true;
			path.add(front);
			List<Integer>children = graph[front];
			for(int i = 0; i<children.size(); i++) {
				int child = children.get(i);
				if(!visited[child])
					que.offer(child);
			}
		}
		System.out.println(path);
	}
}
