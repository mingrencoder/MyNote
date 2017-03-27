package TTTTTTTTTTTTTTest;

import java.util.Scanner;

public class M1 {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean b[][];
		int area = 0;
		int cir = 0;
		b=new boolean[100][100];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(in.nextInt()>50){
					b[i][j]=false;
					continue;
				}
				else{
				
					b[i][j]=true;
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(b[i][j]) {
					area++;
					if(i==0||i==n-1||j==0||j==n-1){
						cir++;
					}else if(b[i-1][j]&&b[i+1][j]&&b[i][j+1]&&b[i][j-1]){
						continue;
					}
					else{
						cir++;
					}
					
				}
			}
		}
	}
}
			
