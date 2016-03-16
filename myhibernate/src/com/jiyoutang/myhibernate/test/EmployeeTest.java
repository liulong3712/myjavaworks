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

		// ����һ�� Hibernate �Ի�
		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		// ����һ������
		Transaction trans = session.beginTransaction();

		// ����ֻè�����ϱ��浽���ݿ�
		session.persist(myEmployee);

		trans.commit();
		session.close();
	}

}
