package com.jiyoutang.myhibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.jiyoutang.myhibernate.session.HibernateSessionFactory;
import com.jiyoutang.myhibernate.session.HibernateUtil;

public class BaseDAO<T> {

	public void create(T object) {
		Session session = 
				HibernateSessionFactory.getSessionFactory().openSession();
		try{
		session.beginTransaction();
		session.persist(object);
		session.getTransaction();
		}catch(Exception e){
			session.getTransaction().commit();
		}finally{
			session.close();
		}
	}
	/**
	 * 更新数据库
	 * 
	 * @param object
	 */
	public void update(T object) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();

		try {
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 从数据库中删除
	 * 
	 * @param object
	 */
	public void delete(T object) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();

		try {
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 查找单个Entity Bean
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T find(Class<? extends T> clazz, Serializable id) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			return (T) session.get(clazz, id);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/**
	 * 查找多个Entity Bean
	 * 
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			return session.createQuery(hql).list();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
}
