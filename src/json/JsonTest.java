package json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONObject;

/*
 * 	1. 把java 对象列表转换为json对象数组，并转为字符串
      JSONArray array = JSONArray.fromObject(list);
      String jsonstr = array.toString();
	2. 把java对象转换成json对象，并转化为字符串
	  JSONObject object = JSONObject.fromObject(user);
	  Log4jInit.ysulogger.debug(object.toString());
	3.把JSON字符串转换为JAVA 对象数组
	  JSONArray json = JSONArray.fromObject(userStr);//userStr是json字符串
	  List<User> users= (List<User>)JSONArray.toCollection(json, User.class);
	4.把JSON字符串转换为JAVA 对象
	　　JSONObject jsonobject = JSONObject.fromObject(jsonStr);
	　　User user= (User)JSONObject.toBean(object,User.class);
 */
public class JsonTest {
	public static void main(String[] args){
		String jsonStr = "{'bList':[{'id':1,'name':'按钮1','state':1},{'id':12,'name':'按钮12','state':0}]}";
		JSONObject jsonobject = JSONObject.fromObject(jsonStr);
		BtnCustom btnCustom= (BtnCustom)JSONObject.toBean(jsonobject, BtnCustom.class);
		System.out.println(btnCustom);
    }
	
	@Test
	public void test1(){
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

		JSONObject jsonObject = JSONObject.fromObject(btnCustom);
		System.out.println(jsonObject.toString());
	}

	@Test
	public void test2(){
		String jsonStr = "{'bList':[{'id':1,'name':'按钮1','state':1},{'id':12,'name':'按钮12','state':0}]}";
		JSONObject jsonobject = JSONObject.fromObject(jsonStr);
		BtnCustom btnCustom= (BtnCustom)JSONObject.toBean(jsonobject, BtnCustom.class);
		
	}
	

}