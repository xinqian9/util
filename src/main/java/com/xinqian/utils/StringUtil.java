package com.xinqian.utils;
/**
 * 
 * @ClassName: StringUtil 
 * @Description: �ַ���������
 * @author:xq
 * @date: 2020��2��11�� ����2:15:52
 */
public class StringUtil {
	//�ж��ַ����Ƿ�Ϊ��
	public static boolean isEmpty(String string) {
		if (null==string || string.equals("")) {
			if(string.trim().length()!=0) {
				return true;
			}
		}
		return false;
	}
	
	//�ж��ַ����Ƿ�������
	public static boolean isEmail(String string) {
		String reg_str="^\\w+@\\w+\\.(com|cn|net|com\\.cn)$";
		boolean matches = string.matches(reg_str);
		return matches;
	}
	//�ж��ַ����Ƿ����ֻ���
	public static boolean isPhone(String string) {
		String reg_str="^1[3-9]\\d{9}$";
		boolean matches = string.matches(reg_str);
		return matches;
	}

}
