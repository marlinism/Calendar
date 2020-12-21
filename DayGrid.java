package Calendar;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class DayGrid {
	
	//method prints everything together to draw out the grid
	public DayGrid(Graphics g, int month, int year) {
		//Draw Table
		drawTable(g);
		
		//Calculate Date
		int dayInmonth = daysInMonth(month, year);
		calculateDate(g, month, year, dayInmonth);
	}
	
	public static void drawTable(Graphics g) {
		int x = 10;
		int y = 40;
		int width = 40;
		int height = 20;
		g.setColor(Color.BLACK);
		//insert the String "SUN MON TUES WED THU FRI SAT SUN"
		g.drawString("SUN    MON   TUE    WED    THU    FRI     SAT",x,y-5);
		
		//draw table
		for(int i = 1; i <= 6; i++) {
			x = 0;
			for(int j = 1; j <= 7; j++) {
			g.drawRect(x, y, width, height);
			x += width;
			}
			y += height;
		}
		
	}

	//method returns amount of days in each month
	public static int daysInMonth(int month, int year) {
		if((month == 2) && (year % 4 == 0)) {
			return 29;
		}
		else if((month == 2) && (year % 4 != 0)) {
			return 28;
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		else {
			return 31;
		}
	}
	//method draws out the the calandar using known variable 
	public static void calculateDate(Graphics g, int month, int year, int dayInmonth) {
		int x = 17;
		int y = 48;
		int width = 40;
		int height = 20;
		int numberOfyear = (year-1) - 1899;
		int numberOfleapyear = numberOfyear / 4;
		int numberbymonth = calculateDaybymonth(month, year);
		int numberOfday = calculateNumberofday(year, numberOfyear, numberOfleapyear, numberbymonth);
		int dayofWeek = numberOfday%7;
		int spaces = dayofWeek -1;
		if(spaces > 0) {
			if(spaces > 7) {
				spaces = spaces - 7;
				for (int i = 0; i <= spaces-1; i++) {
					x = 20;
					y = 64;
					g.drawString("     ", x, y);
					x += width;
				}
			}
		}
		else if (spaces < 0) {
			spaces = 7 + spaces;
			for (int i = 0; i <= spaces-1; i++) {
				x = 20;
				y = 48;
				g.drawString("     ", x, y);
				x += width;
			}
		}
		x = width * spaces;
		for (int i = 1; i <= 7 - spaces; i++) {
			
			String a = Integer.toString(i);
			g.drawString(a, x + 18, y + 8);
			x += width;
		}
		x = 17;
		y += height;
		int count = 1;
		
		for (int i = 8 - spaces; i <= dayInmonth; i++) {
			if(count == 1) {
				String a = Integer.toString(i);
				g.drawString(a, x, y + 8);
			}
			if(count <= 7 && count != 1) {
				String a = Integer.toString(i);
				g.drawString(a, x + 40 , y + 8);
				x += width;
			}
			if(count > 7) {
				x = 17;
				y += height;
				String a = Integer.toString(i);
				g.drawString(a, x, y + 8);
				count = 1;
			}
			count++; 
		}
	}
	
	//method calculates the amount of days in the year including any leap year
	public static int calculateNumberofday(int year, int numberOfyear, int numberOfleapyear, int numberbymonth) {
		int numberOfday;
		//if statement checks if the given year is a leap year or not 
		if(year%4!=0) {
			return numberOfday = (numberOfyear - numberOfleapyear)*365 + (numberOfleapyear+1)*366 + numberbymonth;
		}
		else {
			return numberOfday = (numberOfyear - numberOfleapyear)*365 + (numberOfleapyear+1)*366 + numberbymonth -1;
		}
	}
	
	//method calculates amount of days throughout the month 
	//for example month 1 to month 2 would be 31 days and so forth 
	public static int calculateDaybymonth (int month, int year) {
		if(year % 4 == 0) {
			int[] dayByMonth = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 355};
			return dayByMonth[month-1];
			
		}
		else {
			int[] dayByMonth = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 354};
			return dayByMonth[month-1];
		}
	}
}
