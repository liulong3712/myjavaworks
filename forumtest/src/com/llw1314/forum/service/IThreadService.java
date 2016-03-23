package com.llw1314.forum.service;

import com.llw1314.forum.bean.Thread;

public interface IThreadService<T extends Thread> extends IService<T> {

	public void updateHit(Integer threadId);

}
