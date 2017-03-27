package TTTTTTTTTTTTTTest;

import java.util.Scanner;

public class M3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int x = in.nextInt();
    		int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            System.out.println(m1(arr,x));
        }

        in.close();

	}

	static int m1(int[] arr, int key){
		int low = 0;
		int hight = arr.length-1;
		while(low <= hight){
			int middle = (low+hight)/2;
			if(key == arr[middle]){
				return middle;
			} else if(key < arr[middle]){
				hight = middle - 1;
			} else{
				low = middle + 1;
			}
		}
		return -1-low;
	}
}
