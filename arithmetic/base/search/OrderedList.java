package base.search;
/*
 * 有序表查找：这里的有序表是对元素按照一定顺序进行了排列，再查找
 */
public class OrderedList {
	public static void main(String[] args) {
		int[] a = {1,3,4,4,5,6,7,13,14,17};
		System.out.println(m1(a, 4));
		System.out.println(m2(a, 14, 0, a.length-1));
	}
	
	//折半查找(二分查找)  非递归
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
		return -1;
	}
	
	//递归
	static int m2(int[] arr, int key, int low, int hight){
		if(low > hight){
			return -1;
		}
		int middle = (low+hight)/2;
		if(key == arr[middle]){
			return middle;
		} 
		if(key < arr[middle]){
			return m2(arr, key, low, hight-1);
		} else{
			return m2(arr, key, low+1, hight);
		}
	}
	
	//斐波那契查找

}
