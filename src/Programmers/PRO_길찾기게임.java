package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PRO_길찾기게임 {
	static int index = 0;
	public static void main(String[] args) {
		
		List<Node> list = new ArrayList<>();
        
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
        for(int i = 0; i < nodeinfo.length; i++){
            list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        
        Collections.sort(list, new Comparator<Node>(){
            
            public int compare(Node n1, Node n2){
                if(n1.y > n2.y){
                    return -1;
                }else if(n1.y < n2.y){
                    return 1;
                }else{
                    if(n1.x > n2.x){
                        return 1;
                    }else if(n1.x < n2.x){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        
        Node root = list.get(0);
        int[][] answer = new int[2][list.size()];
        
        for(int i = 1; i < list.size(); i++){
            add(root, list.get(i));
        }
        preorder(answer, root);
        index = 0;
        postorder(answer, root);
	}
	
	static void add(Node par, Node child){
        if(par.x > child.x){
            if(par.left == null){
                par.left = child;
            }else{
                add(par.left, child);
            }
        }else{
            if(par.right == null){
                par.right = child;
            }else{
                add(par.right, child);
            }
        }
   }
	static void preorder(int[][]arr, Node root){
        if(root!=null){
            arr[0][index++] = root.num;
            preorder(arr, root.left);
            preorder(arr, root.right);
        }
    }
    
    static void postorder(int[][]arr, Node root){
        if(root!=null){
            postorder(arr, root.left);
            postorder(arr, root.right);
            arr[1][index++] = root.num;
        }
    }
    
    static class Node{
        int x;
        int y;
        int num;
        Node left;
        Node right;
        
        Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
