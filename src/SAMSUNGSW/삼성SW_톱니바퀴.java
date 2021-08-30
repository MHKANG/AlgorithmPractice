package SAMSUNGSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 삼성SW_톱니바퀴 {
	static int[][]gear = new int[4][8];
	static int[]move;
	static int K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 0; i < 4; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0; j<8; j++) {
				gear[i][j] = Integer.parseInt(input[j]);
			}
			
		}
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i<K; i++) {
			String[] input = br.readLine().split(" ");
			move = new int[4];
			int num = Integer.parseInt(input[0]) -1;
			int dir = Integer.parseInt(input[1]);
			checkGear(num, dir);
			moveGear(move);
		}
		System.out.println(calScore());
		
	}
	
	
	public static void checkGear(int gNum, int dir) {
		int prev = gNum -1;
		int next = gNum +1;
		
		move[gNum] = dir;
		
		if(prev >=0 && move[prev]==0) {
			//왼쪽 검사
			if(gear[prev][2] != gear[gNum][6]) {
				checkGear(prev, dir*-1);
			}
		}
		
		if(next<=3 && move[next]==0) {
			//오른쪽 검사
			if(gear[next][6]!=gear[gNum][2]) {
				checkGear(next, dir*-1);
			}
		}
		
	}
	public static void moveGear(int[]move) {
		for(int i = 0; i <4; i++) {
			if(move[i]!=0) {
				int[]temp = new int[8];
				
				int idx = -1;
				for(int j = 0; j <8; j ++) {
					idx = j + move[i];
					if(idx == -1) {
						idx = 7;
					}else if(idx == 8) {
						idx = 0;
					}
					
					temp[idx] = gear[i][j];
				}
				gear[i] = temp; 
			}
		}
	}
	public static int calScore() {
		int result = 0;
		
		for(int i = 0; i <4; i++) {
			if(gear[i][0]==1) {
				result += Math.pow(2, i);
			}
		}
		return result;
	}
}
