package com.grs.java.mode.facade;

/**
 * 类说明:外观模式是为了解决类与类之家的依赖关系的,像 spring 一样,可以将类和类之间的关系配置到配置文件中,而外观 模式就是将他们的关系放在一个
 * 们以一个计算机的启动过程为例) Facade 类中, 降低了类类之间的耦合度
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月31日 下午1:23:29
 */
public class Computer implements Computorable {

	private CPU cpu;
	private Memory memory;
	private Disk disk;

	public Computer() {
		cpu = new CPU();
		memory = new Memory();
		disk = new Disk();
	}

	@Override
	public void startUp() {
		cpu.startUp();
		memory.startUp();
		disk.startUp();
	}

	@Override
	public void shutDown() {
		cpu.shutDown();
		memory.shutDown();
		disk.shutDown();
	}

}
