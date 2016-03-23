package com.llw1314.forum.service.impl;

import com.llw1314.forum.bean.Thread;
import com.llw1314.forum.service.IThreadService;

public class ThreadServiceImpl<T extends Thread> extends ServiceImpl<T>
		implements IThreadService<T> {

	@Override
	@SuppressWarnings("all")
	public void create(T thread) {

		dao.create(thread);

		int totalCount = dao.getTotalCount(" select count(t) from Thread t "
				+ " where t.deleted = false and t.board.id = "
				+ thread.getBoard().getId(), null);

		dao
				.createQuery(
						" update Board b "
								+ " set b.lastThread.id = :lastThreadId, b.lastReply.id = null, threadCount = :threadCount "
								+ " where b.id = :boardId ").setParameter(
						"lastThreadId", thread.getId()).setParameter("boardId",
						thread.getBoard().getId()).setParameter("threadCount",
						totalCount).executeUpdate();

	}

	public void updateHit(Integer threadId) {

		dao.createQuery(
				" update Thread t set t.hit = t.hit + 1 where t.id = :id ")
				.setParameter("id", threadId).executeUpdate();

	}

}
