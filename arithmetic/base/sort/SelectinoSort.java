package base.sort;
/*
 * 选择排序
 * 设置一个最小值下标的变量，用了if进行判断，由前到后，将小的放在前面
 */
public class SelectinoSort {

	public static void main(String[] args) {
		int a[] = {3,1,4,5,8,2,17,12,10,7};
		selectionSort(a);
		for(int i:a){
			System.out.print(i + " ");
		}
	}
	
	private static void selectionSort(int[] a){
		for(int i=0; i<a.length-1; i++){
			int min = i;	//设置最小值的小标为当前循环的i
			for(int j=i; j<a.length; j++){
				if(a[min]>a[j]){	//当前最小值与后面的值比较
					min = j;
				}
			}
			if(min!=i){ //若这个循环里i值不是最小值的下标
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}

}
