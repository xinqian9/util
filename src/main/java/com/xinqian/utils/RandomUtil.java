package com.xinqian.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * 
 * @ClassName: RandomUtil 
 * @Description: 随机数工具类
 * @author:xq
 * @date: 2020年2月11日 下午6:13:43
 */
public class RandomUtil {
	//返回否个时间段的数据
	public static int getRandomNum(int min,int max) {
		Random random = new Random();
		return random.nextInt(max-min+1)+min;
	}
	//返回四位验证码
	public static String getRandomCheck() {
		
		String str="0123456789abcefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String newString="";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int nextInt = random.nextInt(str.length());
			newString+=str.charAt(nextInt);
		}
		return newString;
	}
	//返回一段文章(至少500字)
	public static String getText() {
		Random random = new Random();
		//常用汉字的高位字节最小值是176 
		//39 一级汉字 16-55区  55-16=39
		int highPos = 176+Math.abs(random.nextInt(39));
		//常用汉字的低位字节最小值是161  a0 0+160+1
		int lowPos = 161+Math.abs(random.nextInt(93));
		byte byteHigh = new Integer(highPos).byteValue();
		byte byteLow = new Integer(lowPos).byteValue();
		byte[] b=new byte[2];
		b[0]=byteHigh;
		b[1]=byteLow;
		String string=null;
		try {
			string=new String(b,"GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
//	public static void main(String[] args) {
//		int randomNum = getRandomNum(1, 120);
//		System.out.println(randomNum);
//		String randomCheck = getRandomCheck();
//		System.out.println(randomCheck);
//		for (int i = 500; i <1000; i++) {
//			String text = getText();
//			System.out.print(text);
//		}
//	}
	
}
