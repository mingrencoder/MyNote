package base.sort;
/*
 * 冒泡排序
 */
public class BubbleSort {

	public static void main(String[] args) {
		int a[] = {3,1,4,5,8,2,17,12,10,7};
		bubbleSort(a);
		for(int i:a){
			System.out.print(i + " ");
		}
	}
	
	private static void bubbleSort(int[] a){
		int temp = 0;
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length-1-i; j++){//这里每一次循环都把最大的放在最后了
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

}
