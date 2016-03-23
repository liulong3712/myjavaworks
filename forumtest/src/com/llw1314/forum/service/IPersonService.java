package com.llw1314.forum.service;

import com.llw1314.forum.bean.Person;

public interface IPersonService<T extends Person> extends IService<T> {

	/** 根据帐号查找用户 */
	public T findPersonByAccount(String account);

	/** 根据帐号、密码查找用户 */
	public T getPerson(String account, String password);

}
