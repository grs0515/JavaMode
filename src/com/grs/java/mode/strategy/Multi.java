package com.grs.java.mode.strategy;

/**
 * 类说明: 乘法
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午2:51:49
 */
public class Multi extends AbstractCalculator implements ICalculator {

	@Override
	public int calculator(String exp) {
		int[] split = split(exp, "\\*");
		return split[0] * split[1];
	}

}
