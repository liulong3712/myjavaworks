package com.jiyoutang.spring.orm;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CatDaoImpl extends HibernateDaoSupport implements ICatDao {

	public void createCat(Cat cat) {
		this.getHibernateTemplate().persist(cat);
	}

	public Cat findCatByName(String name) {
		List<Cat> catList = (List<Cat>)this.getHibernateTemplate()
				.find("select c from Cat c where c.name = ? ", name);
		if (catList.size() > 0)
			return catList.get(0);
		return null;
	}

//	public int getCatsCount() {
//		Number n = (Number)this.getSession(true).createQuery(
//				" select count(c) from Cat c ").uniqueResult();
//		return n.intValue();
//	}

	public List<Cat> listCats() {
		return (List<Cat>)this.getHibernateTemplate().find(" select c from Cat c ");
	}

	@Override
	public int getCatsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
