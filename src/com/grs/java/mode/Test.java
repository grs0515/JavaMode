package com.grs.java.mode;

import com.grs.java.mode.adapter.Source;
import com.grs.java.mode.adapter.SourceAdapter;
import com.grs.java.mode.adapter.SourceSubAdapter;
import com.grs.java.mode.adapter.WrapperAdapter;
import com.grs.java.mode.builder.Builder;
import com.grs.java.mode.decorator.Decorator;
import com.grs.java.mode.decorator.Sourceable;
import com.grs.java.mode.factory.abstracts.BigFactory;
import com.grs.java.mode.factory.abstracts.Boy;
import com.grs.java.mode.factory.abstracts.Girl;
import com.grs.java.mode.factory.abstracts.PersonFactory;
import com.grs.java.mode.factory.abstracts.SmallFactory;
import com.grs.java.mode.factory.simple.SendFactory;
import com.grs.java.mode.factory.simple.Sender;
import com.grs.java.mode.singleton.Singleton;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月29日 下午1:44:03
 */
public class Test {

	public static void main(String[] args) {

		print("单例模式");
		singletonTest();

		print("工厂模式");
		factoryTest();

		print("建造者模式");
		builderTest();

		print("适配器模式");
		adapterTest();

		print("装饰模式");
		decoratorTest();
	}

	/**
	 * 装饰器模式的应用场景:
	 * 
	 * 1 、需要扩展一个类的功能。
	 * 
	 * 2 、动态的为一个对象增加功能,而且还能动态撤销。
	 * 
	 * 缺点:产生过多相似的对象,不易排错!
	 */
	private static void decoratorTest() {
		Sourceable sourceable = new com.grs.java.mode.decorator.Source();
		Decorator decorator = new Decorator(sourceable);
		decorator.method();
	}

	/**
	 * 适配器模式
	 * 
	 * 将某个类的接口转换成客户端期望的另一个接口表示,目的是消除由于接口不匹配所造成的类的兼容性问
	 * 题。主要分为三类:类的适配器模式、对象的适配器模式、接口的适配器模式。
	 * 
	 * 类的适配器模式:当希望将 一个类 转换成满足 另一个新接口 的类时,可以使用类的适配器模式,创建一个新类,继承 原有的类,实现新的接口即可。
	 * 对象的适配器模式: 当希望将一个对象转换成满足另一个新接口的对象时, 可以创建一个 Wrapper 类, 持有原类的一 个实例,在 Wrapper
	 * 类的方法中,调用实例的方法就行。 接口的适配器模式:当不希望实现一个接口中所有的方法时,可以创建一个抽象类 Wrapper ,实现所有方法,我们写
	 * 别的类的时候,继承抽象类即可。
	 */
	private static void adapterTest() {
		// 1,类的适配器模式
		SourceAdapter adapter = new SourceAdapter();
		adapter.method1();
		adapter.method2();
		// 2,对象的适配器模式
		Source source = new Source();
		WrapperAdapter wrapper = new WrapperAdapter(source);
		wrapper.method1();
		wrapper.method2();
		// 3,接口的适配器模式
		SourceSubAdapter sourceSubAdapter = new SourceSubAdapter();
		sourceSubAdapter.method1();// 重写,加super调用父类
		sourceSubAdapter.method2();// 没重写,直接调用父类
	}

	/**
	 * 建造者模式
	 * 
	 * 建造者模式将很多功能集成到一个类里,这个类可以创造出比较复杂的东西。所以与工程模式的区别就
	 * 是:工厂模式关注的是创建单个产品,而建造者模式则关注创建符合对象,
	 */
	private static void builderTest() {
		Builder builder = new Builder();
		builder.produceMailSender(10);
	}

	/**
	 * 简单工厂
	 * 
	 * 总体来说,工厂模式适合:凡是出现了大量的产品需要创建,并且具有共同的接口时,可以通过工厂方法模式进行创
	 * 建。在以上的三种模式中,第一种如果传入的字符串有误,不能正确创建对象,第三种相对于第二种,不需要实例化
	 * 工厂类,所以,大多数情况下,我们会选用第三种——静态工厂方法模式。
	 * 
	 * 复杂工厂
	 * 
	 * 工厂方法模式有一个问题就是,类的创建依赖工厂类,也就是说,如果想要拓展程序,必须对工厂类进行修改,这违
	 * 背了闭包原则,所以,从设计角度考虑,有一定的问题,如何解决?就用到抽象工厂模式,创建多个工厂类,这样一
	 * 旦需要增加新的功能,直接增加新的工厂类就可以了,不需要修改之前的代码。
	 * 
	 */
	private static void factoryTest() {
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

		// 复杂工厂
		PersonFactory smallFactory = new SmallFactory();
		Boy boy = smallFactory.getBoy();
		boy.drawMan();
		Girl girl = smallFactory.getGirl();
		girl.drawWoman();

		PersonFactory bigFactory = new BigFactory();
		Boy boy2 = bigFactory.getBoy();
		boy2.drawMan();
	}

	/**
	 * 单例模式
	 */
	private static void singletonTest() {
		Singleton instance = Singleton.getInstance();
		Singleton.getInstance2();
		Singleton.getInstance3();
	}

	public static void print(String string) {
		System.out.println("**********************" + string + "*************************");
	}
}
