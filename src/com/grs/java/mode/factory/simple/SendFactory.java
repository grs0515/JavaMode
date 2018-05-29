package com.grs.java.mode.factory.simple;

import java.util.Map;

import com.grs.java.mode.util.PropertiesUtil;

/**
 * 类说明:send工厂类
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月29日 下午2:00:45
 */
public class SendFactory implements IFactory {

	public static final String MAIL = "mail";
	public static final String SMS = "sms";

	/**
	 * 根据不同类型获取实现类
	 * 
	 * @param type
	 * @return
	 */
	/* 1,一般情况 */
	public Sender produce(String type) {
		if (MAIL.equals(type)) {
			return new MailSender();
		} else if (SMS.equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型");
			return null;
		}
	}

	/* 2,使用静态方法 */
	public static Sender produce2(String type) {
		if (MAIL.equals(type)) {
			return new MailSender();
		} else if (SMS.equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型");
			return null;
		}
	}

	/* 3,提供指定方法 */
	@Override
	public Sender produceMail() {
		return new MailSender();
	}

	@Override
	public Sender produceSms() {
		return new SmsSender();
	}

	/* 4,使用全类名获取 */
	public Sender produceByClass(String className) {

		Sender sender = null;
		try {
			sender = (Sender) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return sender;
	}

	/* 4,使用配置文件获取 */
	public Sender produceByKey(String key) {
		Map<String, String> properties = new PropertiesUtil().getFactoryProperties();
		Sender sender = null;
		try {
			sender = (Sender) Class.forName(properties.get(key)).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return sender;
	}

}
