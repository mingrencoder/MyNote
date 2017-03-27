package base.sort;
/*
 * 插入排序
 * 将一个记录插入到已经排好序的表中，从而得到一个新的，记录数增加1的有序表
 */
public class InsertionSort {
	public static void main(String[] args) {
		int a[] = {3,1,4,5,8,2,17,12,10,7};
		insertionSort(a);
		for(int i:a){
			System.out.print(i + " ");
		}
	}
	
	private static void insertionSort(int[] a){
		for(int i=2; i<a.length; i++){
			a[0] = a[i];		//设置监视哨
			int j = i-1;
			while(a[j] > a[0]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = a[0];		//将监视哨赋给下一个元素
		}
	}
}
