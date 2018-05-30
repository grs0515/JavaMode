package com.grs.java.mode.adapter;

/**
 * 类说明:适配器模式
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月30日 下午4:45:24
 */
public class SourceAdapter extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("------Adapter--method2------");
	}

}
