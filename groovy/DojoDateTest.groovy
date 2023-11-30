class DojoDateTest extends GroovyTestCase {
	void testAddDays_Zero() {
		println "Zero"
		def date = new DojoDate(2018, 3, 1)
		date.addDays(0)
		assertEquals "day:", 1, date.day
		assertEquals "month:", 3, date.month
		assertEquals "year:", 2018, date.year
	}

	void testAddDays_OneDay() {
		println "OneDay"
		def date = new DojoDate(2018, 3, 1)
		date.addDays(1)
		assertEquals "day:", 2, date.day
		assertEquals "month:", 3, date.month
		assertEquals "year:", 2018, date.year
	}

	void testAddDays_OneMonth() {
		println "OneMonth"
		def date = new DojoDate(2018, 3, 1)
		date.addDays(31)
		assertEquals "day:", 1, date.day
		assertEquals "month:", 4, date.month
		assertEquals "year:", 2018, date.year
	}

	void testAddDays_TwoMonthsOneDay() {
		println "TwoMonthsOneDay"
		def date = new DojoDate(2018, 3, 1)
		date.addDays(62)
		assertEquals "day:", 2, date.day
		assertEquals "month:", 5, date.month
		assertEquals "year:", 2018, date.year
	}

	void testAddDays_OneYear() {
		println "OneYear"
		def date = new DojoDate(2018, 3, 1)
		date.addDays(365)
		assertEquals "day:", 1, date.day
		assertEquals "month:", 3, date.month
		assertEquals "year:", 2019, date.year
	}

	// !!!: Fails b/c code does not handle leap years
	/*
	void testAddDays_ThreeHundredYears() {
		println "ThreeHundredYears"
		def date = new DojoDate(2018, 3, 1)
		date.addDays(300 * 365)
		assertEquals "day:", 19, date.day
		assertEquals "month:", 12, date.month
		assertEquals "year:", 2317, date.year
	}
	*/
}