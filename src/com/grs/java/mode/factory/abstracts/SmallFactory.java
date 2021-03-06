package com.grs.java.mode.factory.abstracts;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月29日 下午3:50:04
 */
public class SmallFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new SmallBoy();
	}

	@Override
	public Girl getGirl() {
		return new SmallGirl();
	}

}
