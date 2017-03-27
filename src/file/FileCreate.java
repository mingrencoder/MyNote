package file;

import java.io.File;

public class FileCreate {

	public static void main(String[] args) {
		File file = new File("/Users/jikai/Documents/船舶企业数据/Log/logDay/"+10010+"/pic/"+1+"-"+2+"-"+3);
		if (!file.exists()  && !file.isDirectory()){       
			file.mkdirs();    
		}
	}

}
