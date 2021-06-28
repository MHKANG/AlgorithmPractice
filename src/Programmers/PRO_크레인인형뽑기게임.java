package Programmers;

import java.util.ArrayList;
import java.util.List;

public class PRO_크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		int answer= 0;
		int N = board[0].length; 
        List<Integer>basket = new ArrayList<Integer>();
       
        for(int i = 0; i < moves.length; i++){
            int mp = moves[i];
            for(int j = 0; j < N; j++){
                 if(board[j][mp-1]!=0){
                	 
                     basket.add(board[j][mp-1]);
                     board[j][mp-1] = 0;
                    
                     int bas_size = basket.size();
                            
                     if(bas_size>=2){
                         if(basket.get(bas_size-1) == basket.get(bas_size-2)){
                            answer+=2;
                            basket.remove(bas_size-1);
                            basket.remove(bas_size-2);
                        }
                     }
                     
                     break;
                 }
            }
        }
        System.out.println(answer);
	}
	public static void printBoard(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
	}
	public static void printBasket(List<Integer>list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) +" ");
		}
		System.out.println();
	}
}
