package TTTTTTTTTTTTTTest;

import java.util.Scanner;

public class M5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = in.nextInt();
        	int[][] l = new int[n][n];
    		for(int i=0; i<n; i++){
    			for(int j=0; j<n; j++){
    				l[i][j] = in.nextInt();
    			}
    		}
    		min(l);
        }

	}

	private static void min(int[][] l) {
		int min = 0;
		
		System.out.println(min);
	}
}
