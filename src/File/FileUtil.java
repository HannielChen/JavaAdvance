package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void main(String[] args)  {
		String destPath = "C:/Users/asus/Desktop/�½��ļ���";
		String srcPath ="C:/Users/asus/Desktop/Դ��";
		
		copyFileToDirectory(destPath, srcPath);
		//System.out.println("�����ɹ�");

	}
	
	public static void copyFile(String destPath, String srcPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if (!src.exists()) {
			System.out.println("Դ�ļ������ڣ�����ʧ��");
			return;
		}
		copyFile(dest, src);
	}
	
	public static void copyFile(File dest, File src) throws IOException {
		if (!src.exists()) {
			System.out.println("Դ�ļ������ڣ�����ʧ��");
			return;
		}
		if(!src.isFile()) {// �����ļ�����Ϊnull
			System.out.println("ֻ�ܿ����ļ���");
			throw new IOException("ֻ�ܿ����ļ�");
		}
		if(dest.isDirectory()) {
			System.out.println(dest.getAbsolutePath() + "\n����ʱ�Ѿ�������Ŀ���ļ�ͬ�����ļ���");
			throw new IOException(dest.getAbsolutePath() + "\n����ʱ�Ѿ�������Ŀ���ļ�ͬ�����ļ���");
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
			//System.out.println(src.getAbsolutePath() + "�������\n");
			
		}
		


	}

	public static void copyFileToDirectory(File dest, File src) {
		if(!src.exists()) {
			System.out.println("Դ�ļ������ڣ�����ʧ��");
			return;
		}
		dest = new File(dest, src.getName());
		copyFileToDirectoryDetail(dest, src);
		//System.out.println("�����ļ��гɹ�");
		
	}
	
	/**
	 * ��Դ�ļ�������Ŀ��Ŀ¼��ȥ
	 * ע�⣺Ŀ��ֻ����Ŀ¼����Դ�ļ��������ļ��п������ļ�
	 * @param destPath Ŀ��Ŀ¼·��
	 * @param srcPath   Դ�ļ�·��
	 */
	public static void copyFileToDirectory(String destPath, String srcPath) {
		File dest = new File(destPath);
		File src = new File(srcPath);
		if(!src.exists()) {
			System.out.println("Դ�ļ������ڣ�����ʧ��");
			return;
		}
		copyFileToDirectory(dest, src);
	}

	public static void copyFileToDirectoryDetail(File dest, File src) {
		
		if(src.isFile()) { //Դ�ļ��������ļ�
			try {
				copyFile(dest, src);
			} catch (IOException e) {
				System.out.println("�ļ�����ʧ�ܣ�");
				e.printStackTrace();
			}
		}
		else {// Դ�ļ�������Ŀ¼
			
			dest.mkdirs();
			
			for(File sub : src.listFiles()) {
				copyFileToDirectory(dest, sub);
			}
		}
	}
}
