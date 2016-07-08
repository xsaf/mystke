package com.arabsoft.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateHandler {
	public DateHandler() {
	}

	private static String dayMonthYearSeparator = "/";
	public static String DateFormat = "dd" + dayMonthYearSeparator + "MM"
			+ dayMonthYearSeparator + "yyyy";

	public static java.util.Date strToDate(String value) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(DateFormat);
			df.setLenient(false);
			return new Date(df.parse(value).getTime());
		} catch (Exception E) {
			return null;
		}
	}

	public static String dateToStr(java.util.Date value) {
		String d = "";
		String m = "";
		if (value == null) {
			return "";
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new java.util.Date(value.getTime()));
			d = String.valueOf(gc.get(Calendar.DATE));
			m = String.valueOf(gc.get(Calendar.MONTH) + 1);
			if (d.length() == 1) {
				d = "0" + d;
			}
			if (m.length() == 1) {
				m = "0" + m;
			}
			return d + dayMonthYearSeparator + m + dayMonthYearSeparator
					+ String.valueOf(gc.get(Calendar.YEAR));
		}
	}

	public static final String dateJour() {
		try {
			DateFormat myformat = new SimpleDateFormat("dd/MM/yyyy");
			return myformat.format(new Date());
		} catch (Exception nmbFormE) {
			return null;
		}

	}

	public static final java.util.Date timeJour() {
		try {
			Date d = new Date();
			return d;
		} catch (Exception nmbFormE) {
			return null;
		}
	}

	public java.util.Date getTimeJour() {

		return new Date();
	}

	public static double getDaysBetween(Date first, Date second) {

		double milliElapsed = second.getTime() - first.getTime();
		double daysElapsed = (milliElapsed / 24F / 3600F / 1000F);
		return (Math.round(daysElapsed * 100F) / 100F);
	}

	
	public static Integer getMonthsBetween(Date first, Date second) {

		int jour = second.getDate() - first.getDate();
		int mois = second.getMonth() - first.getMonth();
		int an = second.getYear() - first.getYear();

		int months = -1;
		if (an >= 0) {
			months = an * 12;

			if (jour >= 0) {
				months = months + mois;
			} else {
				months = months + mois - 1;
			}
		}
		return (new Integer(months));
	}

	public static java.sql.Date utilDateToSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static java.util.Date sqlDateToUtilDate(java.sql.Date date) {
		return new java.util.Date(date.getTime());
	}

	
	public static java.sql.Date addJour(java.sql.Date date, int n) {
		GregorianCalendar gc = new GregorianCalendar(
				TimeZone.getTimeZone("GMT+1"));
		gc.setTime(sqlDateToUtilDate(date));
		gc.add(GregorianCalendar.DAY_OF_MONTH, n);
		return (utilDateToSqlDate(gc.getTime()));
	}

	public static Date addJour(Date date, int n) {
		GregorianCalendar gc = new GregorianCalendar(
				TimeZone.getTimeZone("GMT+1"));
		gc.setTime(date);
		gc.add(GregorianCalendar.DAY_OF_MONTH, n);
		return (gc.getTime());
	}

	
	public static java.sql.Date addMonth(java.sql.Date date, int m) {
		GregorianCalendar gc = new GregorianCalendar(
				TimeZone.getTimeZone("GMT+1"));
		gc.setTime(sqlDateToUtilDate(date));
		gc.add(GregorianCalendar.MONTH, m);
		return (utilDateToSqlDate(gc.getTime()));
	}

	public static Date addMonth(Date date, int m) {
		GregorianCalendar gc = new GregorianCalendar(
				TimeZone.getTimeZone("GMT+1"));
		gc.setTime(date);
		gc.add(GregorianCalendar.MONTH, m);
		return (gc.getTime());
	}

	public static int getAge(Date naissance) {
		double nombreJours = getDaysBetween(
				DateHandler.strToDate("05/05/1980"),
				DateHandler.strToDate("05/06/1988"));
		if (nombreJours < 360) {
			return (0);
		} else {
			return (Double.valueOf(Math.round(nombreJours / 360F)).intValue());
		}
	}

	
	public static int[] getAgeYearMonthDay(Date birthday, Date today) {

		int[] age = new int[3];
		Calendar cBirthday = new GregorianCalendar();
		Calendar cToday = new GregorianCalendar();
		cBirthday.setTime(birthday);
		cToday.setTime(today);
		int yearDiff = cToday.get(Calendar.YEAR) - cBirthday.get(Calendar.YEAR);
		cBirthday.set(Calendar.YEAR, cToday.get(Calendar.YEAR));
		if (cBirthday.before(cToday)) { // Birthday already celebrated this year
			age[0] = yearDiff;
		} else { // Birthday not yet celebrated this year
			age[0] = Math.max(0, yearDiff - 1); // Need a max to avoid -1 for
												// baby
		}
		Date interim = new Date();
		interim.setTime(birthday.getTime());
		interim.setYear(birthday.getYear() + age[0]); // ajouter le nombre
														// d'années, pr calculer
														// mois
		age[1] = getMonthsBetween(interim, today).intValue();
		interim.setMonth(birthday.getMonth() + age[1]); // ajouter les mois, pr
														// calculer les jours
		age[2] = new Double(getDaysBetween(interim, today)).intValue();
		if (age[1] == 12) {
			age[0]++;
			age[1] = 0;
		}
		return age;
	}

	public static int GetYearFromDate(Date date) {

		SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy");
		Long year = Long.valueOf(simpleDateformat.format(date));
		return year.intValue();
	}

	public Date getLastDayOfMonth(Date date) {

		Date d = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		d.setYear(date.getYear());
		d.setMonth(date.getMonth());
		d.setHours(date.getHours());

		if (month == 4 || month == 6 || month == 9 || month == 11) {
			d.setDate(30);
		} else {
			if (month == 2) {
				if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
					d.setDate(29);
				} else
					d.setDate(28);
			} else
				d.setDate(31);
		}
		return d;
	}
	
	
	public static String strToDateCtx(Date date){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateCtx  = df.format(date);
		return dateCtx;
	}

}
