package com.grs.java.mode.factory;

import com.grs.java.mode.factory.abstracts.BigFactory;
import com.grs.java.mode.factory.abstracts.Boy;
import com.grs.java.mode.factory.abstracts.Girl;
import com.grs.java.mode.factory.abstracts.PersonFactory;
import com.grs.java.mode.factory.abstracts.SmallFactory;
import com.grs.java.mode.factory.simple.SendFactory;
import com.grs.java.mode.factory.simple.Sender;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月29日 下午1:44:03
 */
public class FactoryTest {

	public static void main(String[] args) {
		/**
		 * 简单工厂
		 * 
		 * 总体来说,工厂模式适合:凡是出现了大量的产品需要创建,并且具有共同的接口时,可以通过工厂方法模式进行创
		 * 建。在以上的三种模式中,第一种如果传入的字符串有误,不能正确创建对象,第三种相对于第二种,不需要实例化
		 * 工厂类,所以,大多数情况下,我们会选用第三种——静态工厂方法模式。
		 * 
		 */
		// 方式1
		SendFactory sendFactory = new SendFactory();
		Sender sender = sendFactory.produce(SendFactory.MAIL);
		sender.send();
		// 方式2
		Sender produce2 = SendFactory.produce2(SendFactory.SMS);
		produce2.send();
		// 方式3
		Sender produceMail = new SendFactory().produceMail();
		produceMail.send();
		// 方式4
		Sender produceByClass = new SendFactory().produceByClass("com.grs.java.mode.factory.simple.SmsSender");
		produceByClass.send();
		// 方式5
		Sender produceByKey = new SendFactory().produceByKey("mail");
		produceByKey.send();

		/**
		 * 复杂工厂
		 * 
		 * 工厂方法模式有一个问题就是,类的创建依赖工厂类,也就是说,如果想要拓展程序,必须对工厂类进行修改,这违
		 * 背了闭包原则,所以,从设计角度考虑,有一定的问题,如何解决?就用到抽象工厂模式,创建多个工厂类,这样一
		 * 旦需要增加新的功能,直接增加新的工厂类就可以了,不需要修改之前的代码。
		 * 
		 */
		PersonFactory smallFactory = new SmallFactory();
		Boy boy = smallFactory.getBoy();
		boy.drawMan();
		Girl girl = smallFactory.getGirl();
		girl.drawWoman();

		PersonFactory bigFactory = new BigFactory();
		Boy boy2 = bigFactory.getBoy();
		boy2.drawMan();

	}
}
