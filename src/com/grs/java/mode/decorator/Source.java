package com.grs.java.mode.decorator;

/**
 * 类说明:被装饰对象
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月30日 下午5:30:03
 */
public class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("====Source=method======");
	}

}
