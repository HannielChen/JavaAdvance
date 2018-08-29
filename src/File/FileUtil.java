package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void main(String[] args)  {
		String destPath = "C:/Users/asus/Desktop/新建文件夹";
		String srcPath ="C:/Users/asus/Desktop/源码";
		
		copyFileToDirectory(destPath, srcPath);
		//System.out.println("拷贝成功");

	}
	
	public static void copyFile(String destPath, String srcPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if (!src.exists()) {
			System.out.println("源文件不存在，拷贝失败");
			return;
		}
		copyFile(dest, src);
	}
	
	public static void copyFile(File dest, File src) throws IOException {
		if (!src.exists()) {
			System.out.println("源文件不存在，拷贝失败");
			return;
		}
		if(!src.isFile()) {// 不是文件或者为null
			System.out.println("只能拷贝文件！");
			throw new IOException("只能拷贝文件");
		}
		if(dest.isDirectory()) {
			System.out.println(dest.getAbsolutePath() + "\n复制时已经存在与目标文件同名的文件夹");
			throw new IOException(dest.getAbsolutePath() + "\n复制时已经存在与目标文件同名的文件夹");
		}
		try(
				InputStream is = new FileInputStream(src);
				OutputStream os = new FileOutputStream(dest);

				){
			byte[] buffer = new byte[1024];
			int len = 0;
			
			while(-1 != (len = (is.read(buffer)))) {
				os.write(buffer, 0, len);
			}
			
			os.flush();
			//System.out.println(src.getAbsolutePath() + "拷贝完毕\n");
			
		}
		


	}

	public static void copyFileToDirectory(File dest, File src) {
		if(!src.exists()) {
			System.out.println("源文件不存在，拷贝失败");
			return;
		}
		dest = new File(dest, src.getName());
		copyFileToDirectoryDetail(dest, src);
		//System.out.println("复制文件夹成功");
		
	}
	
	/**
	 * 将源文件拷贝到目标目录中去
	 * 注意：目标只能是目录，而源文件可以是文件夹可以是文件
	 * @param destPath 目标目录路径
	 * @param srcPath   源文件路径
	 */
	public static void copyFileToDirectory(String destPath, String srcPath) {
		File dest = new File(destPath);
		File src = new File(srcPath);
		if(!src.exists()) {
			System.out.println("源文件不存在，拷贝失败");
			return;
		}
		copyFileToDirectory(dest, src);
	}

	public static void copyFileToDirectoryDetail(File dest, File src) {
		
		if(src.isFile()) { //源文件对象是文件
			try {
				copyFile(dest, src);
			} catch (IOException e) {
				System.out.println("文件拷贝失败！");
				e.printStackTrace();
			}
		}
		else {// 源文件对象是目录
			
			dest.mkdirs();
			
			for(File sub : src.listFiles()) {
				copyFileToDirectory(dest, sub);
			}
		}
	}
}
