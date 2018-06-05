package com.grs.java.mode;

import com.grs.java.mode.adapter.Source;
import com.grs.java.mode.adapter.SourceAdapter;
import com.grs.java.mode.adapter.SourceSubAdapter;
import com.grs.java.mode.adapter.WrapperAdapter;
import com.grs.java.mode.bridge.Bridge;
import com.grs.java.mode.bridge.MyBridge;
import com.grs.java.mode.bridge.SourceSub1;
import com.grs.java.mode.bridge.SourceSub2;
import com.grs.java.mode.builder.Builder;
import com.grs.java.mode.decorator.Decorator;
import com.grs.java.mode.decorator.Sourceable;
import com.grs.java.mode.facade.Computer;
import com.grs.java.mode.factory.abstracts.BigFactory;
import com.grs.java.mode.factory.abstracts.Boy;
import com.grs.java.mode.factory.abstracts.Girl;
import com.grs.java.mode.factory.abstracts.PersonFactory;
import com.grs.java.mode.factory.abstracts.SmallFactory;
import com.grs.java.mode.factory.simple.SendFactory;
import com.grs.java.mode.factory.simple.Sender;
import com.grs.java.mode.proxy.Proxy;
import com.grs.java.mode.singleton.Singleton;
import com.grs.java.mode.strategy.Strategy;
import com.grs.java.mode.template.Template;

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

		print("代理模式");
		proxyTest();

		print("外观模式");
		facadeTest();

		print("桥接模式");
		bridgeTest();

		print("策略模式");
		strategyTest();

		print("模板方法模式");
		templateTest();
	}

	private static void templateTest() {
		Template template = new Template();
		template.method();
	}

	/**
	 * 策略模式的决定权在用户,系统本身提供不同算法的实现,新增或者删除算法,对各种算法做封装。因此,策略模式
	 * 多用在算法决策系统中,外部用户只需要决定用哪个算法即可。
	 */
	private static void strategyTest() {
		Strategy strategy = new Strategy();
		strategy.method();
	}

	/**
	 * 这样,就通过对 Bridge 类的调用,实现了对接口 Sourceable 的实现类 SourceSub1 和 SourceSub2 的调用。接
	 * 下来我再画个图,大家就应该明白了,因为这个图是我们
	 */
	private static void bridgeTest() {
		Bridge myBridge = new MyBridge();

		com.grs.java.mode.bridge.Sourceable sourceSub1 = new SourceSub1();
		myBridge.setSource(sourceSub1);
		myBridge.method();

		com.grs.java.mode.bridge.Sourceable sourceSub2 = new SourceSub2();
		myBridge.setSource(sourceSub2);
		myBridge.method();

	}

	/**
	 * 如果我们没有 Computer 类,那么, CPU 、 Memory 、 Disk 他们之间将会相互持有实例,产生关系,这样会造成严
	 * 重的依赖,修改一个类,可能会带来其他类的修改,这不是我们想要看到的,有了 Computer 类,他们之间的关系被 放在了 Computer
	 * 类里,这样就起到了解耦的作用,这,就是外观模式!
	 */
	private static void facadeTest() {
		Computer computer = new Computer();
		computer.startUp();
		computer.shutDown();
	}

	/**
	 * 代理模式的应用场景:
	 * 
	 * 如果已有的方法在使用的时候需要对原有的方法进行改进,此时有两种办法: 1 、修改原有的方法来适应。这样违反了 “对扩展开放,对修改关闭 ”的原则。
	 * 2 、就是采用一个代理类调用原有的方法,且对产生的结果进行控制。这种方法就是代理模式。 使用代理模式,可以将功能划分的更加清晰,有助于后期维护!
	 */
	private static void proxyTest() {
		com.grs.java.mode.proxy.Sourceable proxy = new Proxy();
		proxy.method();
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
