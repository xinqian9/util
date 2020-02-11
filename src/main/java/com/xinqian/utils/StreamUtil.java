package com.xinqian.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: StreamUtil 
 * @Description:流的工具类
 * @author:xq
 * @date: 2020年2月11日 下午5:52:08
 */
public class StreamUtil {
	//按字节读取
	public static String ReadByStream(File file) {
		//string的值是不能改变的，拼接一次就开辟一个新的内存空间，占用内存，效率慢
		//stringBuffer/stringBuilder会直接在尾部进行拼接(append)，不会占用内存
		StringBuffer sb = new StringBuffer();
		InputStream ips=null;
		try {
			ips=new FileInputStream(file);
			byte[] b=new byte[1024];
			//读取
			int read = ips.read(b);
			while (read!=-1) {
				sb.append(new String(b));
				read = ips.read();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	//按字符读取
	public static String ReadByChar(File file) {
		StringBuffer sb = new StringBuffer();
		FileReader br=null;
		try {
			br=new FileReader(file);
			char[] c=new char[1024];
			int read = br.read(c);
			while (read!=-1) {
				sb.append(c);
				read= br.read();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	//按行读取
	public static List<String> ReadByLine(InputStream ips) {
		InputStreamReader reader=null;
		BufferedReader br=null;
		ArrayList<String> list = new ArrayList<String>();
		//获取字节输入流
		reader=new InputStreamReader(ips);
		//字节流转换为字符流
		br = new BufferedReader(reader);
		String line="";
		try {
			while ((line=br.readLine())!=null) {
				list.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
