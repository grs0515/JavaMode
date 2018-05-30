package com.grs.java.mode.adapter;

/**
 * 类说明:抽象类 实现接口的所有方法
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月30日 下午5:11:20
 */
public abstract class AbstractSource implements Sourceable {

	@Override
	public void method1() {
		System.out.println("--------AbstractSource--method1------------");
	}

	@Override
	public void method2() {
		System.out.println("--------AbstractSource--method2------------");
	}

}
