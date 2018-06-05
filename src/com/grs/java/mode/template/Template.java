package com.grs.java.mode.template;

/**
 * 类说明:模板方法模式,就是指:一个抽象类中,有一个主方法,再定义 1...n 个方法,可以是抽象的,也可以是实
 * 际的方法,定义一个类,继承该抽象类,重写抽象方法,通过调用抽象类,实现对子类的调用,
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午3:38:04
 */
public class Template {

	public void method() {
		String exp = "8+9";
		AbstractCalculator plus = new Plus();
		int calculate = plus.calculate(exp, "\\+");
		System.out.println(exp + "--------->" + calculate);
	}

}
