public class DojoDate {
	public static final MONTHS_WITH_30DAYS = [ 4, 6, 9, 11 ]
	public int year
	public int month
	public int day

	public DojoDate(int year, int month, int day) {
		this.year = year
		this.month = month
		this.day = day
	}

	public daysInMonth() {
		return month == 2 ? 28 : (MONTHS_WITH_30DAYS.contains(month) ? 30 : 31)
	}

	public void addDays(int daysToAdd) {
		/*
		day = day + daysToAdd

		if (day > daysInMonth(month)) {
			day = day % daysInMonth(month)
			daysToAdd -= daysInMonth(month)
			month ++

			while (daysToAdd > 0) {
				month ++
				daysToAdd -= daysInMonth(month)
			}

			if (month > 12) {
				month = month % 12
				year ++
			}
		}
		*/

		/*
		day += daysToAdd

		while (day > daysInMonth()) {
			day -= daysInMonth()
			month ++

			if (month > 12) {
				year ++
				month = 1
			}
		}
		*/

		year += daysToAdd / 365
		//int yearsToAdd = daysToAdd / 365
		//day += (daysToAdd % 365) + ((yearsToAdd / 100) * 24)
		day += daysToAdd % 365

		while (day > daysInMonth()) {
			day -= daysInMonth()
			month ++

			if (month > 12) {
				year ++
				month = 1
			}
		}
	}
}