package com.ibm;

import org.junit.*;
import static org.junit.Assert.*;

public class StringsTest {
	@Test
	public void testUpper() {
		assertEquals("upper:", "ABC", Strings.upper("abc"));
	}
}