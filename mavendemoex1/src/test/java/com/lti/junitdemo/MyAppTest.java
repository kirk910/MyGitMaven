package com.lti.junitdemo;



import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import com.lti.demo.Calculator;
import com.lti.demo.MyApp;

class MyAppTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void testShow() {
		MyApp m = new MyApp();
		String s = m.show();
		Assertions.assertEquals(s, "hello maven");
	}

	@Test
	void testAdd() {
		int r = Calculator.add(100, 200);
		Assertions.assertEquals(300, r, "hello tester:)");
		Assertions.assertEquals(300, r);
		Assertions.assertNotEquals(30, r);
	}

	@Test
	void testAssertFalse() {
		Assertions.assertFalse("Firosh".length() == 10);
		Assertions.assertFalse(5 > 10, "greater value");
	}

	@Test
	void testAssertNull() {
		String s1 = null;
		String s2 = "abc";
		Assertions.assertNull(s1);
		Assertions.assertNotNull(s2);
	}

//	@Test
//	void testAll() {
//		String s1 = "a";
//		String s2 = "ab";
//		String s3 = "abc";
//		Assertions.assertAll(
//				() -> Assertions.assertNotEquals("a", s1),
//				() -> Assertions.assertNotEquals("ab", s2),
//				() -> Assertions.assertNotEquals("abc", s3));
//		Assertions.assertNull(s1);
//		Assertions.assertNotNull(s2);
//	}
//	
//	@Test
//	void testCollections() {
//		ArrayList<String> myList = new ArrayList<>();
//		myList.add("Hello");
//		Assertions.assertFalse(myList.isEmpty());
//		
//		ArrayList<Integer> myList1 = new ArrayList<>();
//		
//		Assertions.assertEquals(true,myList1.isEmpty());
//		
//		
//	}
//	
//	
	 @Test
	 void testAssumeTrue() {
	      boolean b = "A" == "A";
	      Assumptions.assumeTrue(b);
	     // Assertions.assertEquals("Hello", "Hello");
	 }

	
	 @Test
	 void testAssumeFalse() {
	      boolean b = 'A' != 'A';
	      Assumptions.assumeFalse(b);
	      Assertions.assertEquals("Hello", "Hello");
	 }

 @Test
	 void testAssumeFalseEnvProp() {
	      System.setProperty("env", "prod");
	      Assumptions.assumeFalse("dev".equals(System.getProperty("env")));
	      System.out.println("further code will execute only if above assumption hold");
	 }

	 @Test
	 void testAssumingThat() {
	      System.setProperty("env", "test");
	      Assumptions.assumingThat("test".equals(System.getProperty("env")),
	           () -> {
	        	   Assertions.assertEquals(10, 10);
	                System.out.println("perform below assertions only on the test env");
	                });

	      Assertions.assertEquals(20, 20);
	      System.out.println("perform below assertions on all env");
	 }

}
