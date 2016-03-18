package com.jiyoutang.spring.orm;

import java.util.List;

public interface ICatDao {

	public void createCat(Cat cat);

	public Cat findCatByName(String name);

	public List<Cat> listCats();

	public int getCatsCount();

}
