package com.grs.java.mode.strategy;

/**
 * 类说明:抽象工具类
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午2:39:29
 */
public abstract class AbstractCalculator {

	/**
	 * 分割 字符 然后转为int类型
	 * 
	 * @param exp
	 * @param opt
	 * @return
	 */
	public int[] split(String exp, String opt) {
		String[] split = exp.split(opt);
		int[] arr = new int[2];
		arr[0] = Integer.parseInt(split[0]);
		arr[1] = Integer.parseInt(split[1]);
		return arr;
	}

}
