package com.grs.java.mode.strategy;

/**
 * 类说明:策略模式定义了一系列算法,并将每个算法封装起来,使他们可以相互替换,且算法的变化不会影响到使用算法的客
 * 户。需要设计一个接口,为一系列实现类提供统一的方法,多个实现类实现该接口,设计一个抽象类(可有可无,属 于辅助类),提供辅助函数,
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午2:53:16
 */
public class Strategy {

	public void method() {
		String exp = "2+9";
		ICalculator plus = new Plus();
		int result = plus.calculator(exp);
		System.out.println(exp + "----->" + result);

		String exp1 = "2-9";
		ICalculator minus = new Minus();
		int result1 = minus.calculator(exp1);
		System.out.println(exp1 + "----->" + result1);

		String exp2 = "2*9";
		ICalculator multi = new Multi();
		int result2 = multi.calculator(exp2);
		System.out.println(exp2 + "----->" + result2);

	}
}
