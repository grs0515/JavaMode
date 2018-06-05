package com.grs.java.mode.facade;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午1:21:33
 */
public class Memory implements Computorable {

	@Override
	public void startUp() {
		System.out.println("------Memory--startUp---------");
	}

	@Override
	public void shutDown() {
		System.out.println("------Memory--shutDown---------");
	}

}
