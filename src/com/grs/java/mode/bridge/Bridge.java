package com.grs.java.mode.bridge;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午1:44:48
 */
public class Bridge {

	private Sourceable sourceable;

	public Sourceable getSource() {
		return sourceable;
	}

	public void setSource(Sourceable sourceable) {
		this.sourceable = sourceable;
	}

	public void method() {
		sourceable.method();
	}

}
