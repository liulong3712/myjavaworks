package com.llw1314.forum.service.impl;

import com.llw1314.forum.bean.Board;
import com.llw1314.forum.service.IBoardService;

public class BoardServiceImpl<T extends Board> extends ServiceImpl<T> implements
		IBoardService<T> {

	@Override
	public void create(T board) {

		if (dao.createQuery(
				" from Board b where b.deleted = false and b.name = :name ")
				.setParameter("name", board.getName().trim()).list().size() > 0) {

			throw new RuntimeException("版面 " + board.getName() + " 已经存在。");
		}

		dao.create(board);
	}
}
