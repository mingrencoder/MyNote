package base.search;
/*
 * 总论 查找表分为静态查找表和动态查找表
 * 静态查找表：只作查找操作的查找表
 * 动态查找表：再查找过程中同时插入查找表中不存在的数据元素（汉语词典收录新词）
 * 			或从中删除（清理注销非法用户）已存在的数据元素
 */
/*
 * 顺序查找
 * 又叫做线性查找
 */
public class SequentialSearch {

	public static void main(String[] args) {
		int[] a = {2,4,1,5,3,3,6,7};
		m1(a, 3);
	}
	
	static void m1(int[] arr, int key){
		for(int i=0; i<arr.length; i++){
			if(arr[i] == key){
				System.out.println("找到关键字在第" + i + "位");
			}
		}
	}

}
