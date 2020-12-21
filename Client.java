package Calendar;

import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Month: ");
		int month= input.nextInt();
		System.out.print("Year: ");
		int year = input.nextInt();
		DrawingPanel p = new DrawingPanel(400,200);
		Graphics g = p.getGraphics();
		DayGrid first = new DayGrid(g, month, year);
		
		GregorianCalendar test = new GregorianCalendar(year, month -1, 1);
		String firstday = "First day: " + test.get(Calendar.DAY_OF_WEEK);
		g.drawString(firstday, 0, 20);
	}

}
