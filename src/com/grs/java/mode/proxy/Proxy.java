package com.grs.java.mode.proxy;

/**
 * 类说明:代理模式
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午12:58:02
 */
public class Proxy implements Sourceable {

	private Source source;

	/**
	 * 代理模式就是多一个代理类出来,替原对象进行一些操作,比如我们在租
	 * 房子的时候回去找中介,为什么呢?因为你对该地区房屋的信息掌握的不够全面,希望找一个更熟悉的人去帮你做, 此处的代理就是这个意思。
	 */
	public Proxy() {
		super();
		this.source = new Source();
	}

	@Override
	public void method() {
		before();
		source.method();
		after();
	}

	public void after() {
		System.out.println("-----Proxy--after----");
	}

	public void before() {
		System.out.println("-----Proxy--before----");
	}
}
