package com.llw1314.forum.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.llw1314.forum.dao.impl.DaoImpl;

public class BeanTest {

	public static void main(String[] args) {

		Resource res = new ClassPathResource("applicationContext.xml");
		DefaultListableBeanFactory factory= new DefaultListableBeanFactory ();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(res);
//		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
//				"applicationContext.xml"));

		DaoImpl<Person> myPersonDao = (DaoImpl<Person>) factory.getBean("forumDao");

		Person person = new Person();
		person.setName("liulong");
		person.setEmail("liulong@126.com");

		myPersonDao.create(person);
	}

}