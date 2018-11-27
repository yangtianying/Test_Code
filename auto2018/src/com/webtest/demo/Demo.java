package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Demo {
	@Test
	public void test1() {
		assertEquals(1, 1);

	}

	@Test
	public void test4() {
		assertEquals(1, 1);

	}

	@Test
	public void test3() {
		assertEquals(4, 1);
	}

	@Test
	public void test2() {
		assertEquals(1, 3);
	}

}
