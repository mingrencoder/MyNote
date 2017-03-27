package json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

public class TestGson {

	@Test
	public void test1(){
		String jsonData = "{'id':'1','name':'John', 'state':0}";
		Gson gson = new Gson();
		Btn b = gson.fromJson(jsonData,Btn.class);
		System.out.println(b.getId() + b.getName() + b.getState());
	}
	
	/**
	 * 利用封装的Gson工具类
	 */
	@Test
	public void test2(){
		String jsonData = "{'id':'2','name':'John', 'state':1}";
		Btn b = GsonUtil.GsonToBean(jsonData, Btn.class);
		System.out.println(b.getId() + b.getName() + b.getState());
	}
	
	/**
	 * 套嵌类
	 */
	@Test
	public void test3(){
		String jsonData = "{'bList':[{'id':1,'name':'按钮1','state':1},{'id':12,'name':'按钮12','state':0}]}";
		BtnCustom btnCustom = GsonUtil.GsonToBean(jsonData, BtnCustom.class);
		List<Btn> list = btnCustom.getbList();
		for(Btn b : list){
			System.out.println(b.toString());
		}
	}
	
	/**
	 * 对象转Json
	 */
	@Test
	public void test4(){
		Btn b1 = new Btn((long) 1, "按钮1", 1);
		Btn b2 = new Btn((long) 2, "按钮2", 0);
		Btn b3 = new Btn((long) 3, "按钮3", 1);
		Btn b4 = new Btn((long) 4, "按钮4", 0);
		Btn b5 = new Btn((long) 5, "按钮5", 1);
		List<Btn> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		BtnCustom btnCustom = new BtnCustom();
		btnCustom.setbList(list);
		String str = GsonUtil.GsonString(btnCustom);
		System.out.println(str);
	}
}
