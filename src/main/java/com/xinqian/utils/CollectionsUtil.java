package com.xinqian.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @ClassName: CollectionsUtil 
 * @Description: ���ϴ�������
 * @author:xq
 * @date: 2020��2��11�� ����2:33:43
 */
public class CollectionsUtil {
	//�жϼ����Ƿ�Ϊ��(set��list)
	public static <T> boolean isNullOfCollection(Collection<T> collections) {
		if (collections!=null) {
			Iterator<T> iterator = collections.iterator();
			if (iterator!=null) {
				while (iterator.hasNext()) {
					Object next = iterator.next();
					if (next!=null) {
						return false;
					}
				}
			}
		}
		return true;
	}
	//�жϼ����Ƿ�Ϊ��(map)
	public static <T> boolean isNullOfMap(Map<String, Integer> map) {
		return map==null || map.isEmpty(); 
	}
}
