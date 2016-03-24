package com.llw1314.forum.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.llw1314.forum.dao.impl.DaoImpl;

public class myfirstJunitTest {

//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	Resource res;
	DefaultListableBeanFactory factory;
	XmlBeanDefinitionReader reader;
	@Before
	public void initSession() {
		System.out.println("开始了...");
		res = new ClassPathResource("applicationContext.xml");
		factory= new DefaultListableBeanFactory ();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(res);
	}
	@After
	public void afterSession(){
		System.out.println("结束了...");
	}
	@Test
	public void test() {
		System.out.println("已进入测试程序...");
		DaoImpl<Person> myPersonDao = (DaoImpl<Person>) factory.getBean("dao");

		Person person = new Person();
		person.setName("liulong");
		person.setEmail("liulong@126.com");

		myPersonDao.create(person);
	}

}
