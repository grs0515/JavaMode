package com.grs.java.mode.util;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 类说明:properties配置文件工具类
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年5月29日 下午2:34:32
 */
public class PropertiesUtil {

	// 工厂模式-配置
	public Map<String, String> getFactoryProperties() {
		return this.getProperties("../factory/type.properties");
	}

	/**
	 * 根据路径获取配置键值对
	 * 
	 * @param path
	 * @return
	 */
	private Map<String, String> getProperties(String path) {
		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream in = PropertiesUtil.class.getResourceAsStream(path);
			props.load(in);
			Enumeration<?> en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String property = props.getProperty(key);
				map.put(key, property);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
