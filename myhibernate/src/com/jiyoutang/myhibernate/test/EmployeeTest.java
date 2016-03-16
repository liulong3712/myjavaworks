package com.jiyoutang.myhibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jiyoutang.myhibernate.bean.Cat;
import com.jiyoutang.myhibernate.bean.Employee;
import com.jiyoutang.myhibernate.session.HibernateSessionFactory;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee myEmployee = new Employee();
		myEmployee.setAge(10);
		myEmployee.setName("liulong");

		// 开启一个 Hibernate 对话
		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		// 开启一个事务
		Transaction trans = session.beginTransaction();

		// 将三只猫的资料保存到数据库
		session.persist(myEmployee);

		trans.commit();
		session.close();
	}

}
