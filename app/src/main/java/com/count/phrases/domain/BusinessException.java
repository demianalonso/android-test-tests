package com.count.phrases.domain;

import java.util.Collection;

public class BusinessException extends RuntimeException {

	public BusinessException(String message) {
		super(message);
	}

	public static void assertTrue(boolean condition, String message) {
		if (!condition) {
			throw new BusinessException(message);
		}
	}

	public static void validationFail(String message) {
		assertTrue(false, message);
	}

	public static void validateCondition(boolean condition, String message) {
		assertTrue(condition, message);
	}

	public static void assertAllNotNull(String message, Object... objs) {
		for (Object object : objs) {
			assertNotNull(object, message);
		}
	}

	public static void assertAllNotEmpty(String message, String... strings) {
		for (String string : strings) {
			assertFalse("".equals(string), message);
		}
	}

	public static void assertFalse(boolean condition, String message) {
		assertTrue(!condition, message);
	}

	public static void assertNotEmpty(Collection<?> objects, String message) {
		assertFalse(objects.isEmpty(), message);
	}

	public static void assertNull(Object object, String message) {
		assertTrue(object == null, message);
	}

	public static void assertNotNull(Object object, String message) {
		assertTrue(object != null, message);
	}

	public static void assertEquals(Object obj1, Object obj2, String message) {
		assertNotNull(obj1, message);
		assertNotNull(obj2, message);

		assertTrue(obj1.equals(obj2), message);
		assertTrue(obj1 == obj2, message);
	}

}
