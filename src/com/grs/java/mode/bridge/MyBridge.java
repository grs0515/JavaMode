package com.grs.java.mode.bridge;

/**
 * 类说明:桥接模式就是把事物和其具体实现分开,使他们可以各自独立的变化。桥接的用意是: 将抽象化与实现化解耦,使得 二者可以独立变化 ,像我们常用的
 * JDBC 桥 DriverManager 一样, JDBC 进行连接数据库的时候,在各个数据库之
 * 间进行切换,基本不需要动太多的代码,甚至丝毫不用动,原因就是 现,用一个叫做数据库驱动的程序来桥接就行了。
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午1:47:17
 */
public class MyBridge extends Bridge {

	@Override
	public void method() {
		getSource().method();
	}
}
