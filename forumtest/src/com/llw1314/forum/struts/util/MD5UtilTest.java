package com.llw1314.forum.struts.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MD5UtilTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("方法开始前");
	}

	@Test
	public void testCalc() {
		System.out.print(MD5Util.calc(""));
		//fail("Not yet implemented");
	}

}
