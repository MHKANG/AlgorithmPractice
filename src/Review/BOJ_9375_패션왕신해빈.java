package Review;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_9375_패션왕신해빈 {
	static int result; // 의상 입을 수 있는 경우의 수
	static String[][] clothes;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		 
		for(int i = 0; i < n; i++) {
			
			HashMap<String, Integer> clothes = new HashMap<>();
			
			int cloth = sc.nextInt();
			
			for(int j=0; j < cloth; j++) {
				sc.next(); // 옷 이름은 필요가 없다. 왜냐하면 종류만 알고 있으면 그 종류의 수에서 조합을 통해 경우의 수를 뽑아 내면 되기 때문
				
				String kind = sc.next(); // 옷의 종류
				
				if(clothes.containsKey(kind)) {
					// 기존에 있는 종류의 옷이면 개수의 +1
					clothes.put(kind, clothes.get(kind)+1);
				}else {
					// 기존에 없는 옷이면 새로 해시 맵을 추가
					clothes.put(kind, 1);
				}
			}
			
			int result = 1;
			// 총 경우의 수는 내가 현재 종류 별로 입을 수 있는 가지수 끼리 곱하는 것이다.
			for(int v : clothes.values()) {
				result = result*(v+1); // 안입는 경우도있기 때문에 안입는 not을 포함해야 함으로 각 경우의 수에다가 +1을 한다.
			}
			result = result -1; // 모든 옷을 안입는 경우가 딱 하나 존재 하기 때문에 이를 빼줘야 한다.
			
			System.out.println(result);
		}
		
	}
	
	
}
