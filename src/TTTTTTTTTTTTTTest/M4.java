package TTTTTTTTTTTTTTest;
/*
 * 假如一个数组中存储了一个股票，在一天交易窗口内各时间点的股票价格（正整数）。只允许一次买入和一次卖出，请提供一个算法，计算出通过卖出和买入可以得到的最大利润
	输入
	价格序列，用,号隔开
	输出
	最大的可能利润

	样例输入
	2,3,2,4
	样例输出
	2
 */
import java.util.Scanner;

public class M4 {
	public static void main(String[] args) {  
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.nextLine();
			String[] str = s.split(",");
			int[] price = new int[str.length];
			for(int i=0; i<price.length; i++){
				price[i] = Integer.valueOf(str[i]);
			}
			System.out.println(m(price));
		}
           
    }

	private static int m(int[] price) {
		int low = price[0];
		int high = price[0];
		int max = 0;
		for(int i=1; i<price.length; i++){
			if(price[i] > high){  
				high = price[i];  
                if(max < high - low){  
                	max = high - low;  
                }  
            }else if(price[i] < low){  
            	low = price[i];  
            	high = price[i];  
            }
		}
		return max;
	}  
}
