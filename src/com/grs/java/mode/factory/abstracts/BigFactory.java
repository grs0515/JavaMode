package com.grs.java.mode.factory.abstracts;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月29日 下午3:55:03
 */
public class BigFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new BigBoy();
	}

	@Override
	public Girl getGirl() {
		return new BigGirl();
	}

}
