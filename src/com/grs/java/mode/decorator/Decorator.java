package com.grs.java.mode.decorator;

/**
 * 类说明:装饰模式
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月30日 下午5:31:04
 */
public class Decorator implements Sourceable {
	/**
	 * 装饰模式
	 * 
	 * 顾名思义,装饰模式就是给一个对象增加一些新的功能,而且是动态的,要求装饰对象和被装饰对象实现同一个接口, 装饰对象持有被装饰对象的实例,
	 */
	private Sourceable sourceable;

	public Decorator(Sourceable sourceable) {
		this.sourceable = sourceable;
	}

	@Override
	public void method() {
		System.out.println("=====before==method========");
		sourceable.method();
		System.out.println("=====after==method=========");
	}

}
