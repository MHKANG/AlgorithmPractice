package Codility.Lesson03;

public class Cod_FrogJmp {
	// Correctness : 100% , Task Score = 100% Performance : 100% 
	public static void main(String[] args) {
		int X = 10;
		int Y = 85;
		int D = 30;
		
		int distance = Y-X;
		int answer = (int)Math.ceil((double)distance/D);
		
		System.out.println(answer);
	}
}	
