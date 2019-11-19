package com.fansongsong;

import java.util.Random;

/**
 * 
 * @ClassName: CmsRandom 
 * @Description: TODO
 * @author: Creazy丿绝情
 * @date: 2019年11月19日 下午4:24:19
 */
public class CmsRandom {
	
	/**
	 *  获取整数类型的随机数
	 * @param min  随机数最小数值
	 * @param max  随机数最大数值
	 * @return
	 */
	public static int getRandomInt(int min,int max) {
		Random random = new Random();
		return min +  random.nextInt(max-min+1);
		
	}
	
	/**
	 * 获取长整数类型的随机数
	 * @param min
	 * @param max
	 * @return
	 */  //  100   1000
	public static long getRandomLong(long min,long max) {
		//Random random = new Random();
		double random = Math.random();// 0 ~ 1 
		return (long)(random * (max-min+1) +  min);
	}

}
