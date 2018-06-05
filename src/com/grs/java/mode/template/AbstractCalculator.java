package com.grs.java.mode.template;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午3:31:40
 */
public abstract class AbstractCalculator {

	/* 主方法,实现对本类其它方法的调用 */
	public final int calculate(String exp, String opt) {
		int[] arr = split(exp, opt);
		return calculate(arr[0], arr[1]);
	}

	public abstract int calculate(int i, int j);

	private int[] split(String exp, String opt) {
		String[] split = exp.split(opt);
		int[] arr = new int[2];
		arr[0] = Integer.parseInt(split[0]);
		arr[1] = Integer.parseInt(split[1]);
		return arr;
	}

}
