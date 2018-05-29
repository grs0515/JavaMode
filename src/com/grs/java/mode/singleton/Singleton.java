package com.grs.java.mode.singleton;

/**
 * 单例对象( Singleton )是一种常用的设计模式。在 Java 应用中,单例对象能保证在一个 JVM 中,该对象只有一个
 * 实例存在。这样的模式有几个好处: 1 、某些类创建比较频繁,对于一些大型的对象,这是一笔很大的系统开销。 2 、省去了 new
 * 操作符,降低了系统内存的使用频率,减轻 GC 压力。 3
 * 、有些类如交易所的核心交易引擎,控制着交易流程,如果该类可以创建多个的话,系统完全乱了。(比如一个军队
 * 出现了多个司令员同时指挥,肯定会乱成一团),所以只有使用单例模式,才能保证核心交易服务器独立控制整个流
 * 
 * @author gaoruishan
 *
 */
public class Singleton {
	/* null,目的是实现延迟加载 */
	private static Singleton instance = null;

	/*
	 * 持有私有静态实例,防止被引用,此处赋值为
	 * 
	 * 私有构造方法,防止被实例化
	 */ private Singleton() {
	}

	/**
	 * 静态工程方法,创建实例
	 */
	/* 1,一般情况下 */
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	/* 2,多线程情况下 */
	public static Singleton getInstance2() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	/* 3,完美的单例模式 */
	public static Singleton getInstance3() {
		return SingletonFactory.instance;
	}

	// 此处使用一个内部类来维护单例
	private static class SingletonFactory {
		private static Singleton instance = new Singleton();
	}

	/* 如果该对象被用于序列化,可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return instance;
	}
}