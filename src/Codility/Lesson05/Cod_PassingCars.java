package Codility.Lesson05;

public class Cod_PassingCars {
	public static void main(String[] args) {
		int answer = 0;
		
		int[]A = {0,1,0,1,1};
		
        boolean[] check = new boolean[A.length];
        int eastCount, westCount = 0;
        int imCount = 0;
        int oneCount = 0;
        for(int i = 0; i < check.length; i++){
            
            if(A[i] == 1){
                check[i] = true;
                westCount++;
                oneCount++;
            }else{
                imCount += oneCount;
            }
            

        }
        eastCount = A.length - westCount;

        answer = eastCount * westCount - imCount;

        if(answer>1000000000)
            answer = -1;
        
        System.out.println(answer);
	}
}
