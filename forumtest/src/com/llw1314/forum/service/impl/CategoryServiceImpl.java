package com.llw1314.forum.service.impl;

import com.llw1314.forum.bean.Category;
import com.llw1314.forum.service.ICategoryService;

public class CategoryServiceImpl<T extends Category> extends ServiceImpl<T>
		implements ICategoryService<T> {

	@Override
	public void create(T category) {

		if (dao.createQuery(
				" from Category c where c.name = :name and c.deleted = false ")
				.setParameter("name", category.getName()).list().size() > 0) {

			throw new RuntimeException("类别 " + category.getName() + " 已经存在。");
		}

		dao.create(category);
	}
}
