package com.grs.java.mode.factory.simple;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月29日 下午1:49:50
 */
public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("------SmsSender------");
	}

}
