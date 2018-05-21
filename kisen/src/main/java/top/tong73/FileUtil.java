package top.tong73;

import java.io.File;

public class FileUtil {

	public static void main(String[] args) {
        File file = new File("D:\\MyFileTest");

		// 遍历文件夹
		listDir(file);
	}
	
	/**
	 * 
	 * @param file 要遍历的文件夹
	 */
	public static void listDir(File file) {
		//System.out.println(file + "*");
		
		// 列出文件夹里面的所有内容
		File[] files = file.listFiles();
		
		// 遍历获取每个File对象
		for (File f : files) {
			// 文件夹。接着在遍历这个文件夹
			if (f.isDirectory()) {
				listDir(f);
			} else if(f.isFile()){	// 文件
				System.out.println(f);//打印出文件的路径
                //复制.doc文件到指定目录
                if (f.getName().endsWith(".doc")) {
					System.out.println(".doc:"+f);
                    File file2 = new File("C:\\MyFileTest\\copy\\" + f.getName());
                    boolean renameFlag = f.renameTo(file2);
					if(renameFlag){
                        System.out.println("复制"+f+"文件成功！");
                        return;
                    }

                }

			}
		}
	}
}