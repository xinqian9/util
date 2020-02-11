package com.xinqian.utils;
/**
 * 
 * @ClassName: StringUtil 
 * @Description: 字符串工具类
 * @author:xq
 * @date: 2020年2月11日 下午2:15:52
 */
public class StringUtil {
	//判断字符串是否为空
	public static boolean isEmpty(String string) {
		if (null==string || string.equals("")) {
			if(string.trim().length()!=0) {
				return true;
			}
		}
		return false;
	}
	
	//判断字符串是否是邮箱
	public static boolean isEmail(String string) {
		String reg_str="^\\w+@\\w+\\.(com|cn|net|com\\.cn)$";
		boolean matches = string.matches(reg_str);
		return matches;
	}
	//判断字符串是否是手机号
	public static boolean isPhone(String string) {
		String reg_str="^1[3-9]\\d{9}$";
		boolean matches = string.matches(reg_str);
		return matches;
	}

}
