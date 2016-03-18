package com.jiyoutang.spring.orm;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class OrmRun {

	public static void main(String[] args) {

		Resource res = new ClassPathResource("applicationContext.xml");
		DefaultListableBeanFactory factory= new DefaultListableBeanFactory ();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(res);
//		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
//				"applicationContext.xml"));

		ICatDao catDao = (ICatDao) factory.getBean("catDao");

		Cat cat = new Cat();
		cat.setName("Hello Kitty");
		cat.setCreatedDate(new Date());

		catDao.createCat(cat);

		List<Cat> catList = catDao.listCats();

		for (Cat c : catList) {
			System.out.println("Name: " + c.getName());
		}

	}

}
