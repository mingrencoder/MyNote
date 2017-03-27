package TTTTTTTTTTTTTTest;
/*
 * T组数据，每组n个人，m次交换，注意交换的是按照初始每个人的序号，再根据位置交换
 * 后面m条数据代表：第一个a要在b前面
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class M2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T>0){
			int n = in.nextInt();
			int m = in.nextInt();
			List<Integer> list = new LinkedList<Integer>();
			for(int i=0; i<n; i++){
				list.add(i+1);
			}
			while(m>0){
				int a = in.nextInt();
				int b = in.nextInt();
				int index1 = list.indexOf(a);
				int index2 = list.indexOf(b);
				if(index1>index2){
					list.remove(index1);
					list.add(index2, a);
				}
				m--;
			}
			for(int i=0; i<n-1; i++){
				System.out.print(list.get(i) + " ");
			}
			System.out.println(list.get(n-1));
			T--;
		}

	}

}
