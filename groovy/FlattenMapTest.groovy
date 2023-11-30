import static groovy.test.GroovyAssert.*

class FlattenMapTest extends GroovyTestCase {
	void testFlatten() {
		def fm = new FlattenMap1()
		assertEquals "1 entry:", [a: 1], fm.flatten([a: 1])
		assertEquals "2 entries:", [a: 1, b: 2], fm.flatten([a: 1, b: 2])
		assertEquals "1x nested:", [a: 1, "b.c": 1], fm.flatten([a: 1, b: [c: 1]])
		assertEquals "2x nested:", [a: 1, "b.c.d": 1], fm.flatten([a: 1, b: [c: [d: 1]]])
	}
}
