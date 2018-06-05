package com.grs.java.mode.facade;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午1:22:29
 */
public class Disk implements Computorable {

	@Override
	public void startUp() {
		System.out.println("-------Disk--startUp--------");
	}

	@Override
	public void shutDown() {
		System.out.println("-------Disk--shutDown--------");
	}

}
