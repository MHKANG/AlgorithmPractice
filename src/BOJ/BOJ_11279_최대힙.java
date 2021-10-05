package BOJ;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11279_최대힙 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer>pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(pq.isEmpty()) {
					sb.append(0 + "\n");
				}else {
					// -1을 곱하는 이유는 우선순위 큐에서 기본적으로 가장 작은 값을 먼저 내보내기 때문에
					// 집어 넣을 때 값에 -1 을 곱해서 음수로 역전을 시켜놓고 집어넣었기 때문에 이를 돌려 놓기 위해서
					sb.append(pq.poll()*-1 +"\n");
				}
			}else {
				// -1을 곱하는 이유는 우선순위 큐에서 기본적으로 가장 작은 값을 먼저 내보내기 때문에
				// -1을 곱해서 값의 크기를 역전 시키기 위해서 이다.
				pq.add(x*-1);
			}
		}
		System.out.println(sb.toString());
	}
}
