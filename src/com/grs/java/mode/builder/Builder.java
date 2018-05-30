package com.grs.java.mode.builder;

import java.util.ArrayList;
import java.util.List;

import com.grs.java.mode.factory.simple.MailSender;
import com.grs.java.mode.factory.simple.Sender;
import com.grs.java.mode.factory.simple.SmsSender;

/**
 * 类说明:建造者模式
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月29日 下午5:00:00
 */
public class Builder {
	/**
	 * 工厂类模式提供的是创建单个类的模式,而建造者模式则是将各种产品集中起来进行管理,用来创建复合对象,所谓 复合对象就是指某个类具有不同的属性,
	 * 其实建造者模式就是前面抽象工厂模式和最后的 Test 结合起来得到的。
	 */
	public Builder() {
		System.out.println("------Builder 构造方法-----");
	}

	private List<Sender> mailList = new ArrayList<Sender>();

	// 提供创建数据
	public List<Sender> getMailList() {
		return mailList;
	}

	/**
	 * 创建创建符合对象,多个部分
	 * 
	 * @param count
	 * @return
	 */
	public Builder produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			mailList.add(new MailSender());
		}
		return this;
	}

	public Builder proudecSmsSender(int count) {
		for (int i = 0; i < count; i++) {
			mailList.add(new SmsSender());
		}
		return this;
	}

}
