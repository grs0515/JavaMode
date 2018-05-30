package com.grs.java.mode.adapter;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月30日 下午5:08:32
 */
public class SourceSubAdapter extends AbstractSource {

	@Override
	public void method1() {
		super.method1();// 调用父类
		System.out.println("----SourceSubAdapter--method1-----");
	}

}
