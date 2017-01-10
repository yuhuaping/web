package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 文件工具
 * 
 * @author scxh
 *
 */
public class FileUtil {
	/**
	 * 
	 * 创建多级文件目录 指定文件 如: e:/liu/hai/bing.txt
	 */
	public static boolean createFile(File file) {
		if(file.exists()){
			return true;
		}
		try {
			String fileDir = file.getPath();
			int lastIndex = fileDir.lastIndexOf(File.separator);
			String dir = fileDir.substring(0, lastIndex);
			File dirFile = new File(dir);
			dirFile.mkdirs();
			if (file.createNewFile()) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * e:/liu/hai/bing.txt
	 * 
	 * @param path
	 * @return
	 */
	public static boolean createFile(String path) {
		File file = new File(path);
		boolean f = createFile(file);
		return f;
	}

	public static File createNewFile(String path) {
		File file = new File(path);
		createFile(file);
		return file;

	}
	
	/**
	 * 根据盘符 e:/zip_demo.zip
	 * 
	 * @param zipPath
	 *            压缩文件 e:/zip_demo.zip
	 * @param zipDirPath
	 *            解压文本目录 e:/zip_demo/
	 */
	public static void deZipFile(String zipPath, String zipDirPath) {
		File zipFile = new File(zipPath);
		File zipDir = new File(zipDirPath);
		deZipFile(zipFile, zipDir);
	}

	/**
	 * 解压压缩文件 e:/zip_demo.zip 到文件目录zip_demo
	 * 
	 * @param zipFile
	 *            压缩文件 e:/zip_demo.zip
	 * @param zipDir
	 *            解压文本目录 e:/zip_demo/
	 */
	public static void deZipFile(File zipFile, File zipDir) {
		try {
			FileInputStream fis = new FileInputStream(zipFile);
			ZipInputStream zis = new ZipInputStream(fis);

			ZipEntry zipEntry = null; // �ļ���Ŀ
			while ((zipEntry = zis.getNextEntry()) != null) {
				File itemFile = new File(zipDir, zipEntry.getName());
				FileUtil.createFile(itemFile);

				System.out.println(itemFile.getPath()); // e:\zip_demo\hello.txt
				FileOutputStream fos = new FileOutputStream(itemFile);
				int c;
				while ((c = zis.read()) != -1) {
					fos.write(c);
				}

				fos.close();
			}

			zis.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param filePaths
	 *            盘符数组参数 如: String[] filePaths = {"e:/java.txt","e:/test.txt};
	 * @param zipPath
	 *            压缩目录文件 如: String zipPath = e:/demo.zip
	 */
	public static void zipFile(String[] filePaths, String zipPath) {
		int length = filePaths.length;
		File[] files = new File[length];
		for (int i = 0; i < length; i++) {
			files[i] = new File(filePaths[i]);
		}
		File zipFile = new File(zipPath);

		zipFile(files, zipFile);
	}

	/**
	 * 
	 * @param files
	 *            需要压缩的所有文件
	 * @param zipFile
	 *            压缩生成目标文件
	 */
	public static void zipFile(File[] files, File zipFile) {
		int fileLength = files.length;
		String[] entryNames = new String[fileLength];
		for (int j = 0; j < fileLength; j++) {
			entryNames[j] = files[j].getName();
		}
		try {
			/*
			 * 压缩文件 将e:/hello10.txt文件压缩成 e:/zip_demo.zip文件
			 */
			//第一步 :创建压缩文件输出流
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (int i = 0; i < fileLength; i++) {
				ZipEntry testEntry = new ZipEntry(entryNames[i]);
				zos.putNextEntry(testEntry); //写文件条目

				FileInputStream fis = new FileInputStream(files[i]);
				int c;
				while ((c = fis.read()) != -1) {
					zos.write((char) c); //写文件内容
				}

				fis.close();
			}

			System.out.println("ѹ���ɹ�!");
			// 最后关闭流
			zos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean deleteFile(String path) throws FileNotFoundException {
		return deleteFile(new File(path));
	}

	/**
	 * 删除指定文件
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static boolean deleteFile(File file) throws FileNotFoundException {
		if(file == null){
			throw new NullPointerException("删除文件不能为空!");
		}
		
		if(!file.exists()){
			throw new FileNotFoundException("文件不存在!");
		}
		
		if (file.isFile()) {
			file.delete();  //删除文件
			return true;
		}

		if(file.isDirectory()){
			File[] fileLists = file.listFiles();
			for(File f : fileLists){
				deleteFile(f);
			}
			file.delete(); //删除空目录
		}
		
		return true;

	}
}
