package TTTTTTTTTTTTTTest;

import java.util.Scanner;

public class M6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = in.nextInt();
        	int count = 0;
        	int temp = 0;
    		for(int i=1; i<=n; i++){
    			temp = i;
    			while(temp%5==0 && temp!=1){
    				count ++;
    				temp /= 5;
    			}
    		}
    		System.out.println(count);
    		
        }

	}

}
