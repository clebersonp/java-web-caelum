package br.com.caelum.jdbc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateUtils {

	public static Calendar parse(java.sql.Date date) {
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		}
		return null;
	}

	public static String format(Calendar dataNascimento, String format) {
		return dataNascimento != null ? new SimpleDateFormat(format).format(new Date(dataNascimento.getTimeInMillis())) : null;
	}

	public static java.sql.Date parse(Calendar date) {
		return date != null ? new java.sql.Date(date.getTimeInMillis()) : null;
	}
}