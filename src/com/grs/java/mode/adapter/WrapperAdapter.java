package com.grs.java.mode.adapter;

/**
 * 类说明:对象的适配器模式
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月30日 下午4:51:20
 */
public class WrapperAdapter implements Targetable {

	private Source source;

	public WrapperAdapter(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("-------Wrapper--method2-----");
	}

}
