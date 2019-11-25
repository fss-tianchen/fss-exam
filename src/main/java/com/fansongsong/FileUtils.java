package com.fansongsong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: FileUtils 
 * @Description: TODO
 * @author: Creazy丿绝情
 * @date: 2019年11月19日 下午4:23:45
 */
public class FileUtils {
	
	/**
	 * 
	 * @Title: readFile 
	 * @Description: 读取文件  每行都放到List 中的一行
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @return: List<String>
	 */
	public static List<String> readFile(String fileName) throws IOException{
		List<String> lines =  new ArrayList<String>();
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file),"UTF-8")
				);
		String str = null;
		while((str=reader.readLine())!=null) {
			lines.add(str);
		}
		return lines;
	}
	
	/**
	 * 
	 * @Title: readFileContent 
	 * @Description: 读取一个文本文件
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFileContent(String fileName) throws IOException{
		StringBuilder sb = new StringBuilder();
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file),"UTF-8")
				);
		String str = null;
		while((str=reader.readLine())!=null) {
			sb.append(str);
		}
		reader.close();
		return sb.toString();
	}
	
}
