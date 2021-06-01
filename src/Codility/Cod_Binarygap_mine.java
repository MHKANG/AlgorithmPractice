package Codility;

public class Cod_Binarygap_mine {
	// Correctness : 80%
	public static void main(String[] args) {
		int N =66561;
		
		int answer = 0;
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        int binarygap = 0;
        boolean checkgap = false;
        int start_idx = 0;
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1' && !checkgap){
                start_idx = i;
                checkgap = true;
            }else if(i >= 1 && binary.charAt(i-1)=='1'&&binary.charAt(i) =='1' && checkgap) {
            	start_idx = i;
            	
            }else if(binary.charAt(i)=='1' && checkgap){
                binarygap = i - start_idx-1;
                answer = Math.max(binarygap, answer);
                start_idx = i;    
            }
        }
        
        System.out.println(answer);
		
	}
}
