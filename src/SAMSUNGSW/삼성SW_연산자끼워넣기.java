package SAMSUNGSW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 삼성SW_연산자끼워넣기 {
	static int N;
	static int[] numbers;
	static int[] operators;
	static List<Character> oList;
	static Character[] op = {'+', '-','*','/'};
	static Character[] select;
	static boolean[] isSelected;
	
	static int Max = -1000000000;
	static int Min = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		operators = new int[4];
		oList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		for(int i = 0; i < 4; i++) {
			operators[i] = sc.nextInt();
		}
		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < operators[i]; j++) {
				oList.add(op[i]);
			}
		} 
		select = new Character[oList.size()];
		isSelected = new boolean[oList.size()];
		
		permu(oList.size(), oList.size(), 0);
		
		System.out.println(Max);
		System.out.println(Min);
		
		
	}
	
	public static void permu(int N, int R , int cnt) {
		if(cnt == R) {
			int result = 0;
			result = numbers[0];
			for(int i = 1; i < numbers.length; i++) {
				if(select[i-1].equals('+')) {
					result = result + numbers[i];
				}
				if(select[i-1].equals('-')) {
					result = result - numbers[i];
				}
				if(select[i-1].equals('*')) {
					result = result * numbers[i];
				}
				if(select[i-1].equals('/')) {
					result = result / numbers[i];
				}
				
			}
			Max = Math.max(Max, result);
			Min = Math.min(Min, result);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i])continue;
			select[cnt] = oList.get(i);
			isSelected[i] = true;
			permu(N, R, cnt+1);
			isSelected[i] = false;
		}
	}
}
