package top.tong73;

import java.io.*;

public class FileUtil {

	public static void main(String[] args) {
        //给出要复制的源文件夹与目标文件夹
        File src = new File("H:\\北京传智26期资料-无视频版");
        File dest = new File("D:\\copy");

        System.out.println("开始复制");
        copyDIR2DIR(src, dest);
        System.out.println("复制结束");
	}

    /*
     * 将源文件夹src复制到目标文件夹dest
     */
    public static void copyDIR2DIR(File src,File dest) {

        //在目标文件夹中创建新的源文件夹
        File destDir = dest;
        //File destDir = new File(dest, src.getName());
        //destDir.mkdirs();

        //遍历源文件夹,获取当中所有的文件对象(可能是文件,也可能是文件夹)
        File[] listFiles = src.listFiles();

        //使用增强for循环
        for (File listFile : listFiles) {
            //判断是文件还是文件夹
            if(listFile.isDirectory()) {
                //如果是文件夹
                //将该文件夹放到目标文件夹中新的源文件夹中
                File oldDir = listFile;
                File newDir = destDir;
                //递归调用,复制文件夹
                copyDIR2DIR(listFile, newDir);
            }else if(listFile.isFile() && listFile.getName().endsWith(".doc") || listFile.getName().endsWith(".docx") ){// 以.doc结尾的文件
                //如果是文件
                //将该文件复制到目标文件夹中新的源文件夹中
                File newFile = new File(destDir, listFile.getName());

                //完成文件复制
                copyFile(listFile, newFile);
            }
        }
    }

    /*
     * oldFile:被复制的老文件
     * newFile:复制成的新文件
     *
     * 使用最简单地一次一个字节的方式复制
     */
    private static void copyFile(File oldFile, File newFile) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //创建流对象
            bis = new BufferedInputStream(new FileInputStream(oldFile));
            bos = new BufferedOutputStream(new FileOutputStream(newFile));
            //读入,写出
            //定义变量记录每次复制的字节
            int b;
            //循环读取
            while((b=bis.read())!=-1) {
                //写出字节
                bos.write(b);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}