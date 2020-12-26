import java.time.LocalDate;
public class WorkingDate {

	public static LocalDate BringBackDate(LocalDate ld) {
		//LocalDate ld = LocalDate.now();
		System.out.println(ld);
		int day = ld.getDayOfMonth();
		int month = ld.getMonthValue();
		int year = ld.getYear();
		day +=7;
		if(day>31) {
			day-=31;
			month+=1;
			if(month>12) {
				month-=12;
				year+=1;
			}
		}
		LocalDate ldb = LocalDate.of(year, month, day);
		return ldb;
	}
	
	public static void main(String[] args) {
		
		LocalDate testD = LocalDate.of(2020, 12, 30);
		System.out.println(BringBackDate(testD));
	}

}
