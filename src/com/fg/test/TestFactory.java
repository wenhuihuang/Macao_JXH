package com.fg.test;

import org.junit.Test;

import com.fg.utils.ToolsUtils;

public class TestFactory {
	@Test
	public void testMethod(){
		System.out.println(ToolsUtils.getCurrentMethodName());
	}
	
	@Test
	public void testMethod2(){
		System.out.println("Hello");
		testMethod();
		System.out.println(ToolsUtils.getCurrentMethodName());
	}
	 
}
