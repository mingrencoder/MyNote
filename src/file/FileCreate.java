package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class FileCreate {

	//创建文件夹
	public void createDir() {
		File file = new File("D:\\a");
		if (!file.exists()  && !file.isDirectory()){       
			file.mkdirs();    
		}
	}

	@Test
	public void test1() throws Exception{
		createDir();
		
		String filename = "1.java";
		File f = new File("D://a", filename);
		
		FileOutputStream fos = new FileOutputStream(f);
		
		//将stringSrc直接写入
		String stringSrc = "通过原始方法写入的字符串";
		FileWriter fw = new FileWriter(f);
		fw.write(stringSrc);
		fw.flush();
		fw.close();
		
		
		//读取网络传入并写入
		/*InputStream is = item.getInputStream(); 
		int len = 0;
		byte[] buff = new byte[1024];
		while((len = is.read(buff)) != -1){
			System.out.println(buff.toString());
			fos.write(buff, 0, len);
		}
		
		fos.flush();
		fos.close();
		is.close();*/
	}
	
	@Test
	public void test2() throws IOException{
		createDir();

		String stringSrc = "通过Common.io包FileUtils工具写入的字符串";
		File file = new File("D://a/2.java");
		FileUtils.writeStringToFile(file, stringSrc);
		
	}
}
