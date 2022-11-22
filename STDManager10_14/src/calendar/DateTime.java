package calendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateTime {
	
	private int year;
	private int month;
	private int todaydate;
	private Object todayday;
	private Calendar calendar=null;
	private LocalDate today=null;
	
	public DateTime() {
		today = LocalDate.now();
		year = today.getYear();
		month = today.getMonthValue();
		todaydate = today.getDayOfMonth();
		todayday = DayOfWeek(findDayOfWeek());		
	}	
	
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getTodaydate() {
		return todaydate;
	}
	

	public int findDayOfWeek() {
		calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public dateType DayOfWeek(int fdw) {
		dateType today = null;
		switch(fdw){
		case 1: today = dateType.일요일; break;
		case 2: today = dateType.월요일; break;
		case 3: today = dateType.화요일; break;
		case 4: today = dateType.수요일; break;
		case 5: today = dateType.목요일; break;
		case 6: today = dateType.금요일; break;
		case 7: today = dateType.토요일; break;
		}
		return today;
	}
	
	public String format() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMM");
		return today.format(formatter);
	}
	//이번달 1일 요일
	public int startDay() {
		LocalDate date = LocalDate.of(year, month, 1);
		return date.getDayOfWeek().getValue();
	}
	
	//이번달 첫번째 일요일 날짜
	public int getStartSundayOfMonth() {
		int i = startDay();
		int sundaydate=0;
		do {
			i++; sundaydate++;
			if(i>7) i=1;
		}while((!((""+DayOfWeek(i)).equals("일요일"))));
		return sundaydate;
	}

	//이전달 마지막날
	public int getLastDateOfMonth() {
		calendar = Calendar.getInstance();
		calendar.set(year,month-1,1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	//이번달 마지막날
		public int getNowDateOfMonth() {
			calendar = Calendar.getInstance();
			calendar.set(year,month,1);
			return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
	//주차계산
	public int calFirstWeek() {
		int weekDate = 0;
		if(startDay()<5) {
			weekDate=getStartSundayOfMonth();
		}
		else weekDate=getLastDateOfMonth()-(startDay()-1); 
		return weekDate;
	}
	
	//이번달 평일 날짜수
	public int cntWeekdate() {
		Calendar start = Calendar.getInstance();
		start.set(year,month,1);
		Calendar end = Calendar.getInstance();
		end.set(year,month,getNowDateOfMonth());
		int workingDays = 0;
		while (!start.after(end)) {
			int day = start.get(Calendar.DAY_OF_WEEK);
			if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
				workingDays++;
			start.add(Calendar.DATE, 1);
			}
		return workingDays;
	}
	
	public String toString() {
		return year+"년 "+month+"월 "+todaydate+"일 "+todayday;
	}
	
}



/*
public static void main(String[] args) {
	System.out.println(today());
	System.out.println(DayOfWeek(findDayOfWeek()));
} */


