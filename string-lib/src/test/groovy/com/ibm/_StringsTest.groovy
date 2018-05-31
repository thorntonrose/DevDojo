package com.ibm

import org.junit.*
import static groovy.test.GroovyAssert.*

class StringsTest {
	@Test
	void testUpper() {
		assertEquals "upper:", "ABC", Strings.upper("abc")
	}
}